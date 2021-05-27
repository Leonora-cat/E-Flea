package cpt202.bughunter.eflea.service;

import cpt202.bughunter.eflea.domain.Message;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface MessageService {
    int getMessageNum(String username);

    List<String> getContactList(String username);

    List<Message> getContactDetail(String user1, String user2);

    void addNewContent(String sender, String receiver, String content);

    int getTotalMessageNum();
}
