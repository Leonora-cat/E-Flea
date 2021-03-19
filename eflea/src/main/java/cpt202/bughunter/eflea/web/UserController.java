package cpt202.bughunter.eflea.web;

import cpt202.bughunter.eflea.domain.User;
import cpt202.bughunter.eflea.service.UserService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "login", notes = "receive username and password, if the user exists, return all the info")
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
