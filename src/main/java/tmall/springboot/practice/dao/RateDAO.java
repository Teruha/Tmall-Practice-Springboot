package tmall.springboot.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tmall.springboot.practice.pojo.Product;
import tmall.springboot.practice.pojo.Rate;

import java.util.List;

public interface RateDAO extends JpaRepository<Rate, Integer> {
    List<Rate> searchByProduct(Product p);
    int countByProduct(Product p);
}
