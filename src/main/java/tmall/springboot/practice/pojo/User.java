package tmall.springboot.practice.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.nio.channels.SocketChannel;
import java.util.List;

/*
*   和SSM框架一样，Springboot的后端数据实体仍旧从一个POJO开始，区别只在于，这里的POJO和数据库处理模块开始直接相连
*   避免了反复编写XML文件的麻烦
* */

@Entity
// 这里使用Entity来使得一个POJO持久化
@Table(name = "UserInfo")
// 和SSM中不同，一个POJO可以作为一个数据实体直接关联到数据表
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class User {

    @Id
    // 这里直接设置主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String password;
    private String name;
    private String salt;

    @ManyToMany(cascade=CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_coupon",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "coupon_id", referencedColumnName = "id"))
    private List<DiscountCoupon> discountCoupons;

    @Transient
    private String anonymousName;
    // 匿名用户的值为一个临时变量，因此对于此POJO过程不需要进行持久化，减少储存空间


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(this.password != null)
            this.password = password.trim();
        else
            this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(this.name != null)
            this.name = name.trim();
        else
            this.name = name;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        if(this.salt != null)
            this.salt = salt.trim();
        else
            this.salt = salt;
    }

    public List<DiscountCoupon> getDiscountCoupons() {
        return discountCoupons;
    }

    public void setDiscountCoupons(List<DiscountCoupon> discountCoupons) {
        this.discountCoupons = discountCoupons;
    }

    public String getAnonymousName() {
        if(null!=anonymousName)
            return anonymousName;
        if(null==name)
            anonymousName= null;
        else if(name.length()<=1)
            anonymousName = "*";
        else if(name.length()==2)
            anonymousName = name.substring(0,1) +"*";
        else {
            char[] cs =name.toCharArray();
            for (int i = 1; i < cs.length-1; i++) {
                cs[i]='*';
            }
            anonymousName = new String(cs);
        }
        return anonymousName;
    }

    public void setAnonymousName(String anonymousName) {
        this.anonymousName = anonymousName;
    }

    // Getters and setters end
}
