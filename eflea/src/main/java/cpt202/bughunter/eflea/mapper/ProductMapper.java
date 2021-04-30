package cpt202.bughunter.eflea.mapper;

import cpt202.bughunter.eflea.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;


@Mapper
public interface ProductMapper {
    @Select("select * from product ORDER BY PID DESC")
    List<Product> allProduct();


    @Select("SELECT * FROM PRODUCT WHERE tag = #{tag} ORDER BY PID DESC LIMIT 0, 8")
    List<Product> displayFirstProduct(@Param("tag") String tag);

    @Select("SELECT * FROM PRODUCT WHERE tag = #{tag} ORDER BY PID DESC")
    List<Product> findByTag(@Param("tag") String tag);

    @Select("SELECT * FROM PRODUCT WHERE UID = #{name}")
    List<Product> findProductByName(@Param("name") String name);

    @Select("SELECT * FROM PRODUCT WHERE name = #{name} ORDER BY PID DESC")
    Product findProductByPName(@Param("name") String name);

    @Select("SELECT * FROM PRODUCT WHERE PID = #{pid}")
    Product findProductByPID(@Param("pid") Long pid);

    @Select("SELECT * FROM PRODUCT WHERE NAME LIKE #{key} AND UID = #{name} ORDER BY PID DESC")
    List<Product> search(@Param("key") String key, @Param("name") String name);

    @Select("SELECT * FROM PRODUCT WHERE NAME LIKE #{key} ORDER BY PID DESC")
    List<Product> searchAll(@Param("key") String key);

    @Select("SELECT * FROM PRODUCT WHERE UID = #{name} AND STATE = 0 ORDER BY PID DESC")
    List<Product> selling(@Param("name") String name);

    @Select("SELECT * FROM PRODUCT WHERE UID = #{name} AND STATE = 1 ORDER BY PID DESC")
    List<Product> sold(@Param("name") String name);

    @Insert("INSERT INTO PRODUCT(PID, NAME, PRICE, TAG, lifeTime, description, uid, state, time) VALUES(#{pid}, #{name}, " +
            "#{price}, #{tag}, #{lifeTime}, #{description}, #{uid}, #{state}, #{time})")
    void insertProduct(@Param("pid") Long id, @Param("name") String name, @Param("price") Double price, @Param("tag") String tag,
                       @Param("lifeTime") String lifeTime, @Param("description") String description, @Param("uid") String uid,
                       @Param("state") Boolean state, @Param("time") Date time);

    @Delete("DELETE FROM product WHERE PID = #{pid}")
    void deleteProduct(@Param("pid") Long pid);

    @Update("UPDATE PRODUCT SET PRICE = #{price}, LIFETIME = #{lifeTime}, " +
            "DESCRIPTION = #{description} WHERE PID = #{pid}")
    void updateProduct(@Param("pid") Long id, @Param("price") Double price,
                       @Param("lifeTime") String lifeTime, @Param("description") String description);

    @Insert("UPDATE PRODUCT SET IMAGE1 = #{image1}, IMAGE2 = #{image2}, IMAGE3 = #{image3} WHERE PID = #{pid}")
    void insertImage(@Param("image1") byte[] image1, @Param("image2") byte[] image2, @Param("image3") byte[] image3,
                     @Param("pid") Long pid) ;

    @Update("UPDATE PRODUCT SET STATE = #{state} WHERE PID = #{pid}")
    void updateState(@Param("state") Boolean state, @Param("pid") Long pid);

    @Update("UPDATE PRODUCT SET TIME = #{time} WHERE PID = #{pid}")
    void publishTime(@Param("time") Date date, @Param("pid") Long pid);


}