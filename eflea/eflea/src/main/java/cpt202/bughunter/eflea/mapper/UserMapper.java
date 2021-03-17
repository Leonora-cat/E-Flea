package cpt202.bughunter.eflea.mapper;

import cpt202.bughunter.eflea.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM eflea_user WHERE username=#{username} AND password=#{password}")
    User getUserByNameAndPwd(String username, String password);

    @Insert("INSERT INTO eflea_user(username,password,sex) VALUES (#{username},#{password},#{sex});")
    void insertUser(String username,String password, String dateOfBirth, Boolean sex);
}
