package cpt202.bughunter.eflea.web;

import cpt202.bughunter.eflea.domain.User;
import cpt202.bughunter.eflea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public Map<String, Object> toLogin(@RequestBody User user){
        Map<String,Object> userMap = new HashMap<>();
        User realUser = userService.toLogin(user.getUsername(),user.getPassword());
        if(realUser!=null){
            userMap.put("status","success");
            userMap.put("userInfo",realUser);
        }
        else{
            userMap.put("status","error");
        }
        return userMap;
    }
}
