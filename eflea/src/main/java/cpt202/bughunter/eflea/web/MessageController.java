package cpt202.bughunter.eflea.web;

import cpt202.bughunter.eflea.domain.Message;
import cpt202.bughunter.eflea.domain.User;
import cpt202.bughunter.eflea.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/{username}/message")
    @ApiOperation(value = "messageNumber", notes = "return message number")
    public String homePage(@PathVariable("username") String username) {
        int messageNum = messageService.getMessageNum(username);
        return String.valueOf(messageNum);
    }

    @GetMapping("/{username}/contactList")
    @ApiOperation(value = "contactList", notes = "return user's contact list")
    public List<String> getContactList(@PathVariable("username") String username) {
        return messageService.getContactList(username);
    }

    @GetMapping("/{username1}/{username2}/contactDetail")
    @ApiOperation(value = "contactDetail", notes = "return contact detail between two users")
    public List<Message> getContactDetail(@PathVariable("username1") String username1, @PathVariable("username2") String username2) {
        return messageService.getContactDetail(username1, username2);
    }

    @PostMapping("/addContent")
    @ApiOperation(value = "addNewContent", notes = "add new content and return whole content list")
    public List<Message> addNewContent(@RequestBody Message message) {
        messageService.addNewContent(message.getSender(), message.getReceiver(), message.getContent());
        return messageService.getContactDetail(message.getSender(), message.getReceiver());
    }

    @GetMapping("/getTotalMessageNum")
    @ApiOperation(value="getTotalMessageNum", notes="get total message number")
    public Map<String, Integer> getTotalMessageNum(){
        int totalNum = messageService.getTotalMessageNum();
        Map<String, Integer> totalNumber = new HashMap<>();
        totalNumber.put("totalNum",totalNum);
        return totalNumber;
    }
}
