package cpt202.bughunter.eflea.mapper;

import cpt202.bughunter.eflea.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {
    @Select("SELECT * FROM admin WHERE adminName=#{adminName} AND password=#{password}")
    Admin getAdminByNameAndPwd(@Param("adminName") String adminName, @Param("password") String password);

    @Select("SELECT * FROM admin WHERE adminName=#{adminName}")
    Admin getAdminByName(@Param("adminName") String adminName);

    @Update("UPDATE admin SET adminMail = #{mail}")
    void update(@Param("mail") String mail);
}
