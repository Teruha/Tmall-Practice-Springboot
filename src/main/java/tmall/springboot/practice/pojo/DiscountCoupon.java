package tmall.springboot.practice.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.*;

@Entity
// 和对User这个Pojo的处理一样，将一张优惠券设定为一个实体
@Table(name = "Coupon")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class DiscountCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "coupons")
    private List<User> users = new ArrayList<>();
    // 同一张优惠券可能会被不同的多个用户领取。

    @Column(name = "expire_Date")
    private Date expire_Date;

    @Column(name = "promoteMoney")
    private float promoteMoney;

    public float getPromoteMoney() {
        return promoteMoney;
    }

    public void setPromoteMoney(float promoteMoney) {
        this.promoteMoney = promoteMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Date getExpire_Date() {
        return expire_Date;
    }

    public void setExpire_Date(Date expire_Date) {
        this.expire_Date = expire_Date;
    }
}
