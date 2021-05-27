package cpt202.bughunter.eflea.service.impl;

import cpt202.bughunter.eflea.domain.Message;
import cpt202.bughunter.eflea.mapper.MessageMapper;
import cpt202.bughunter.eflea.service.MessageService;
import cpt202.bughunter.eflea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    @Override
    public int getMessageNum(String username) {
        return messageMapper.getMessageNum(username);
    }

    @Override
    public List<String> getContactList(String username) {
        return messageMapper.getContactList(username);
    }

    @Override
    public List<Message> getContactDetail(String user1, String user2) {
        return messageMapper.getContactDetail(user1,user2);
    }

    @Override
    public void addNewContent(String sender, String receiver, String content) {
        messageMapper.addNewContent(sender,receiver,content);
    }

    @Override
    public int getTotalMessageNum() {
        return messageMapper.getTotalMessageNum();
    }
}
