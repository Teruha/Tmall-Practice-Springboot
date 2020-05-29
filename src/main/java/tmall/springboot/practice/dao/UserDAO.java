package tmall.springboot.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tmall.springboot.practice.pojo.User;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findByName(String name);
    User getByNameAndPassword(String name, String password);
    User resignByNameAndPassword(String name, String password);
}
