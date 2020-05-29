package tmall.springboot.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tmall.springboot.practice.pojo.DiscountCoupon;

public interface DiscountCouponDAO extends JpaRepository<DiscountCoupon, Integer> {
}
