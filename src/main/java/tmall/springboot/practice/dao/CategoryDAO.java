package tmall.springboot.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tmall.springboot.practice.pojo.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {
}
