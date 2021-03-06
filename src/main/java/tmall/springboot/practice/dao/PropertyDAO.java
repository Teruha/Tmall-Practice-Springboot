package tmall.springboot.practice.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tmall.springboot.practice.pojo.Category;
import tmall.springboot.practice.pojo.Property;

import java.util.List;

public interface PropertyDAO extends JpaRepository<Property, Integer> {
    static Page<Property> findByCategory(Category category, Pageable pageable);//一个分类有多个属性，当提供分类时，根据分类查属性。
    List<Property> findByCategory(Category category);//一次性拿出一个目录下的所有属性
}
