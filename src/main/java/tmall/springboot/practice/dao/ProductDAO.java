package tmall.springboot.practice.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tmall.springboot.practice.pojo.Category;
import tmall.springboot.practice.pojo.Product;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {
    Page<Product> findByCategory(Category category, Pageable pageable);
    List<Product> findByNameLike(String keyword, Pageable pageable);
    List<Product> findByCategoryOrderById(Category category);
}
