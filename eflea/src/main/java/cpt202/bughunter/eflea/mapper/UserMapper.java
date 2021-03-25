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

    @Insert("INSERT INTO user(username,password,email,major,dateOfBirth,sex) VALUES (#{username},#{password},#{email},#{major},#{dateOfBirth},#{sex});")
    void insertUser(@Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("major") String major, @Param("dateOfBirth") Date dateOfBirth, @Param("sex") Boolean sex);

    @Select("UPDATE user SET email=#{email} WHERE userID=#{userID}")
    User updateEmail(@Param("email") String email, @Param("userID") Long userID);

    @Select("UPDATE user SET major=#{major} WHERE userID=#{userID}")
    User updateMajor(@Param("major") String email, @Param("userID") Long userID);

    @Select("UPDATE user SET dateOfBirth=#{dateOfBirth} WHERE userID=#{userID}")
    User updateDateOfBirth(@Param("dateOfBirth") Date dateOfBirth, @Param("userID") Long userID);

    @Select("UPDATE user SET sex=#{sex} WHERE userID=#{userID}")
    User updateSex(@Param("sex") Boolean sex, @Param("userID") Long userID);
}
