package tmall.springboot.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tmall.springboot.practice.pojo.Order;
import tmall.springboot.practice.pojo.OrderItem;
import tmall.springboot.practice.pojo.Product;
import tmall.springboot.practice.pojo.User;

import java.util.List;

public interface OrderItemDAO extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByOrderOrderByIdDesc(Order order);
    List<OrderItem> findByProduct(Product product);
    List<OrderItem> findByUserAndOrderIsNull(User user);
}
