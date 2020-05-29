package tmall.springboot.practice.service;


// import com.tdunning.math.stats.Sort;
// False import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tmall.springboot.practice.dao.UserDAO;
import tmall.springboot.practice.pojo.DiscountCoupon;
import tmall.springboot.practice.pojo.User;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
@CacheConfig(cacheNames = "users")
public class UserService {


    @Autowired
    UserDAO userDAO;

    @Autowired
    DiscountCouponService discountCouponService;

    public List<User> list(){
        Sort sort = new Sort(Sort.Direction.DESC,
                "id");
        return userDAO.findAll(sort);
    }

    public boolean isExist(String name){
        User user = getByName(name);
        if(user == null)
            return false;
        return true;
    }

    public User getByName(String name){
        return userDAO.findByName((name));
        // 仅通过用户名做查询
    }

    public User get(String name, String pwd){
        return userDAO.getByNameAndPassword(name, pwd);
        // 通过用户名和密码做双重查询
    }

    public Page<User> list(int start, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        // old version
        // TODO: update

        Pageable pageable = PageRequest.of(start, size, sort);
        return userDAO.findAll(pageable);
    }

    @Transactional
    public void add(User user) {
        userDAO.save(user);
        //int a = 10/0;//加事务后，模拟异常后回滚。

    }

    public User get(int id) {
        Optional<User> UserInfoOptional = userDAO.findById(id);
        if (!UserInfoOptional.isPresent()) {
            return null;
        }
        return UserInfoOptional.get();
    }

    public void Add(User user){
        add(user);
    }

    @Cacheable(key=" 'users-'+ #p0 + ':coupon-'+ #p1 ",value = "UserCouponInfo" )//这里就是头空间，而不是user为头空间
    public void AddCoupon(int userId,int couponId){
        User user = get(userId);
        DiscountCoupon coupon = discountCouponService.get(couponId);
        List<DiscountCoupon> coupons = user.getDiscountCoupons();
        if(coupons==null){
            user.setDiscountCoupons(coupons);
        }

        for (int i = 0; i < coupons.size(); i++) {
            if(coupons.get(i).getId()==couponId)
                return;
        }
        coupons.add(coupon);
        userDAO.save(user);//如果过期的时候，没有删掉，那么再添加进去就不好用了。因为很难判断是否拥有同一张优惠券,其实可以重写equles
    }

    public void DeleteCoupon(int userId,int couponId){
        User user = get(userId);
        DiscountCoupon coupon = discountCouponService.get(couponId);

        List<DiscountCoupon> coupons = user.getDiscountCoupons();
        if(coupons==null){
            return;
        }
        int coupon_id=0;
        for (int i = 0; i < coupons.size(); i++) {
            if(coupons.get(i).getId()==coupon.getId())
                coupon_id = i;
        }
        coupons.remove(coupon_id);
        userDAO.save(user);
    }
}
