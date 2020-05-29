package tmall.springboot.practice.service;

/*
* 优惠券Service
*  */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tmall.springboot.practice.dao.DiscountCouponDAO;
import tmall.springboot.practice.pojo.DiscountCoupon;

import java.util.Optional;

@Service
// 添加Service注解
public class DiscountCouponService {
    @Autowired
    DiscountCouponDAO discountCouponDAO;

    public DiscountCoupon get(int id){
        Optional<DiscountCoupon> ProductInfoOptional = discountCouponDAO.findById(id);
        if (!ProductInfoOptional.isPresent()) {
            return null;
        }
        DiscountCoupon coupon = ProductInfoOptional.get();
        return coupon;
    }
}
