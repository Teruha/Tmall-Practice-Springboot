package tmall.springboot.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tmall.springboot.practice.dao.ProductDAO;

@Service
public class ProductService {
    @Autowired
    ProductDAO p;;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductImageService productImageService;

    @Autowired
    PropertyValueService propertyValueService;

    @Autowired
    OrderService orderService;

    @Autowired
    RateService rateService;


}
