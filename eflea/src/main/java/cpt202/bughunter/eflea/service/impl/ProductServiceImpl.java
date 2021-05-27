package cpt202.bughunter.eflea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cpt202.bughunter.eflea.domain.Product;
import cpt202.bughunter.eflea.mapper.ProductMapper;
import cpt202.bughunter.eflea.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> allProduct() {

        return productMapper.allProduct();
    }

    @Override
    public List<Product> displayProductByPrice() {
        return productMapper.displayProductByPrice();
    }

    @Override
    public List<Product> displayAll(String tag){
        return productMapper.displayFirstProduct(tag);
    };

    @Override
    public void insert(Long id, String name, Double price, String tag, String lifeTime, String description, String uid,
                       Boolean state, Date time) {
        productMapper.insertProduct(id, name, price, tag, lifeTime, description, uid, state, time);
    }
    @Override
    public List<Product> findProductByName(String name){
        return productMapper.findProductByName(name);
    }

    @Override
    public List<Product> findByTag(String tag) {
        return productMapper.findByTag(tag);
    }

    ;

    @Override
    public Product findProductByPid(Long id){
        return productMapper.findProductByPID(id);
    }

    @Override
    public List<Product> searchAll(String key) {
        return productMapper.searchAll(key);
    }

    @Override
    public List<Product> selling(String name) {
        return productMapper.selling(name);
    }

    @Override
    public List<Product> sold(String name) {
        return productMapper.sold(name);
    }

    ;
    @Override
    public void delete(Long id){
        productMapper.deleteProduct(id);
    };
    @Override
    public void update(Long id, Double price,  String lifeTime, String description){
        productMapper.updateProduct(id, price, lifeTime, description);
    }
    @Override
    public void insertImage(byte[] image1, byte[] image2, byte[] image3, Long id){
        productMapper.insertImage(image1, image2, image3, id);
    }
    @Override
    public void updateState(Boolean state, Long pid){
        productMapper.updateState(state, pid);
    }

    @Override
    public Product findProductByPName(String name) {
        return productMapper.findProductByPName(name);
    }

    @Override
    public void publishTime(Date time, Long pid){
        productMapper.publishTime(time, pid);
    }

    @Override
    public List<Product> search(String key, String name) {
        return productMapper.search(key, name);
    }

    @Override
    public List<Product> findAllProductByPageF(int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        return productMapper.allProduct();
    }

    @Override
    public PageInfo<Product> findAllProductByPageS(int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Product> lists = productMapper.allProduct();
        return new PageInfo<Product>(lists);

    }

    @Override
    public int getTotalSoldNum() {
        return productMapper.getTotalSoldNum();
    }

    @Override
    public int getTotalSellingNum() {
        return productMapper.getTotalSellingNum();
    }

}