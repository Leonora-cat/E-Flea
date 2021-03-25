package cpt202.bughunter.eflea.mapper;

import cpt202.bughunter.eflea.domain.User;
import org.apache.ibatis.annotations.*;

import java.sql.Date;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username=#{username} AND password=#{password}")
    User getUserByNameAndPwd(@Param("username") String username, @Param("password") String password);

    //examine whether the user exists before reset password
    @Select("SELECT * FROM user WHERE username=#{username} AND email=#{email}")
    User getUserByNameAndEmail(@Param("username") String username, @Param("email") String email);

    @Insert("INSERT INTO user(username,password,dateOfBirth,sex) VALUES (#{username},#{password},#{dateOfBirth},#{sex});")
    void insertUser(@Param("username") String username, @Param("password") String password, @Param("dateOfBirth") Date dateOfBirth, @Param("sex") Boolean sex);

    @Update("UPDATE `user` SET password = #{password} WHERE username = #{username} AND email = #{email}")
    void resetPassword(@Param("username") String username, @Param("email") String email, @Param("password") String password);
}
