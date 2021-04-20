package cpt202.bughunter.eflea.service;

import com.github.pagehelper.PageInfo;
import cpt202.bughunter.eflea.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface ProductService {
    List<Product> allProduct();
    List<Product> displayAll(String tag);
    List<Product> findProductByName(String name);
    List<Product> findByTag(@Param("tag") String tag);
    Product findProductByPid(Long id);
    void insert(Long id, String name, Double price, String tag, String lifeTime, String description, String uid, Boolean state, Date time);
    void delete(Long id);
    void update(Long id, String name, Double price, String tag1, String lifeTime, String description);
    void insertImage(byte[] image1, byte[] image2, byte[] image3, Long id);
    void updateState(Boolean state, Long pid);
    Product findProductByPName(String name);
    void publishTime(Date time, Long pid);
    List<Product> search(String key, String name);
    List<Product> findAllProductByPageF(int pageNum,int pageSize);
    PageInfo<Product> findAllProductByPageS(int pageNum, int pageSize);


}
