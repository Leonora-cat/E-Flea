package cpt202.bughunter.eflea.mapper;

import cpt202.bughunter.eflea.domain.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT COUNT(*) FROM message WHERE receiver=#{username}")
    int getMessageNum(@Param("username") String username);

    @Select("SELECT sender FROM message WHERE receiver=#{username} \n" +
            "UNION DISTINCT \n" +
            "SELECT receiver FROM message WHERE sender=#{username};")
    List<String> getContactList(@Param("username") String username);

    @Select("SELECT content,sender,receiver,sendTime FROM message where (sender=#{sender} AND receiver=#{receiver}) OR (sender=#{receiver} AND receiver=#{sender}) ORDER BY sendTime ASC")
    List<Message> getContactDetail(@Param("sender") String sender, @Param("receiver") String receiver);

    @Insert("INSERT INTO message(sender,receiver,content) VALUES (#{sender},#{receiver},#{content})")
    void addNewContent(@Param("sender") String sender, @Param("receiver") String receiver, @Param("content") String content);

    @Select("SELECT COUNT(*) FROM message")
    int getTotalMessageNum();
}
