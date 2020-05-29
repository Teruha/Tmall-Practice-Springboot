package tmall.springboot.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import tmall.springboot.practice.dao.ProductDAO;
import tmall.springboot.practice.dao.RateDAO;
import tmall.springboot.practice.dao.UserDAO;

@Service
@CacheConfig(cacheNames = "rates")
public class RateService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    RateDAO rateDAO;

    @Autowired
    ProductService productService;

}
