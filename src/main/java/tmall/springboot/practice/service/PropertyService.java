package tmall.springboot.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tmall.springboot.practice.dao.CategoryDAO;
import tmall.springboot.practice.dao.PropertyDAO;
import tmall.springboot.practice.pojo.Category;
import tmall.springboot.practice.pojo.Property;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {
    @Autowired
    PropertyDAO propertyDAO;

    @Autowired
    CategoryDAO categoryDAO;

    public Property get(int id){
        Optional<Property> PropertyInfoOptional = PropertyDAO.findByID(id);
        if (!PropertyInfoOptional.isPresent()) {
            return null;
        }
        return PropertyInfoOptional.get();
    }

    public void edit(Property property){
        PropertyDAO.save(property);
    }

    public void delete(int id){
        PropertyDAO.deleteById(id);
    }

    public void add(Property property){
        PropertyDAO.save(p);
    }

    public List<Property> listByCategory(Integer cid){
        Optional<Category> optionalCategory = categoryDAO.findById(cid);
        if(!optionalCategory.isPresent())
            return null;

        return propertyDAO.findByCategory(optionalCategory.get());
        // 教程的原初使用的是service，这里按照一个Bean的内部耦合方法使用DAO
    }

    public Page<Property> listProperty(int start, int size,int cid){
        Optional<Category> optionalCategory = categoryDAO.findById(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        // TODO: Version Changed
        Pageable pageable = PageRequest.of(start, size, sort);//new PageRequest(firstResult, maxResults, new Sort(...))过时
        Page page =PropertyDAO.findByCategory(optionalCategory.get(),pageable);
        return page;
    }
}
