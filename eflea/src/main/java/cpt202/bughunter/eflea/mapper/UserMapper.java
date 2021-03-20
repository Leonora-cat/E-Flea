package cpt202.bughunter.eflea.mapper;

import cpt202.bughunter.eflea.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Date;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username=#{username} AND password=#{password}")
    User getUserByNameAndPwd(String username, String password);

    @Select("SELECT * FROM user WHERE username=#{username}")
    User getUserByName(@Param("username") String username);

    @Insert("INSERT INTO user(username,password,date_of_birth,sex) VALUES (#{username},#{password},#{dateOfBirth},#{sex});")
    void insertUser(@Param("username") String username, @Param("password") String password, @Param("dateOfBirth") Date dateOfBirth, @Param("sex") Boolean sex);
}
