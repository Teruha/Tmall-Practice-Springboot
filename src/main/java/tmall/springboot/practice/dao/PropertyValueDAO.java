package tmall.springboot.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tmall.springboot.practice.pojo.Product;
import tmall.springboot.practice.pojo.Property;
import tmall.springboot.practice.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueDAO extends JpaRepository<PropertyValue, Integer> {
    List<PropertyValue> findByProductOrderByIdDesc(Product product);
    PropertyValue getByPropertyAndProduct(Property property, Product product);
}
