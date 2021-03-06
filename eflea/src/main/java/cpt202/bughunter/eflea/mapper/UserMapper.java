package cpt202.bughunter.eflea.mapper;

import cpt202.bughunter.eflea.domain.User;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username=#{username} AND password=#{password}")
    User getUserByNameAndPwd(@Param("username") String username, @Param("password") String password);

    //examine whether the user exists before reset password
    @Select("SELECT * FROM user WHERE username=#{username} AND email=#{email}")
    User getUserByNameAndEmail(@Param("username") String username, @Param("email") String email);

    @Select("SELECT * FROM user WHERE username=#{username}")
    User getUserByName(@Param("username") String username);

    @Select("SELECT * FROM user WHERE email=#{email}")
    User getUserByEmail(@Param("email") String email);

    @Insert("INSERT INTO user(username,password,major,email,dateOfBirth,sex) VALUES (#{username},#{password},#{major},#{email},#{dateOfBirth},#{sex})")
    void insertUser(@Param("username") String username, @Param("password") String password,@Param("major") String major,@Param("email") String email, @Param("dateOfBirth") Date dateOfBirth, @Param("sex") Boolean sex);

    @Update("UPDATE user SET password = #{password} WHERE username = #{username} AND email = #{email}")
    void resetPassword(@Param("username") String username, @Param("email") String email, @Param("password") String password);

    @Update("UPDATE user SET email=#{email} WHERE username=#{username}")
    User updateEmail(@Param("email") String email, @Param("username") String username);

    @Update("UPDATE user SET major=#{major} WHERE username=#{username}")
    User updateMajor(@Param("major") String major, @Param("username") String username);

    @Update("UPDATE user SET dateOfBirth=#{dateOfBirth} WHERE username=#{username}")
    User updateDateOfBirth(@Param("dateOfBirth") Date dateOfBirth, @Param("username") String username);

    @Update("UPDATE user SET sex=#{sex} WHERE username=#{username}")
    User updateSex(@Param("sex") Boolean sex, @Param("username") String username);

    @Select("SELECT COUNT(*) FROM user")
    int getTotalUserNum();

    @Select("SELECT * FROM user")
    List<User> getUsers();

    @Delete("DELETE FROM user WHERE username=#{username}")
    void deleteUser(@Param("username") String username);
}
