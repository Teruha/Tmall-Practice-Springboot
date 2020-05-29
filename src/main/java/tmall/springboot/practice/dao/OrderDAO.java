package tmall.springboot.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tmall.springboot.practice.pojo.Order;
import tmall.springboot.practice.pojo.User;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Integer> {
    public List<Order> findByUserAndStatusNotOrderByIdDesc(User user, String status);
}
