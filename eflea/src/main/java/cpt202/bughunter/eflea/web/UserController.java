package cpt202.bughunter.eflea.web;

import cpt202.bughunter.eflea.domain.User;
import cpt202.bughunter.eflea.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import java.sql.Date;

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

    @PostMapping(value = "/register")
    @ApiOperation(value = "register a new account", notes = "require username, password, dateOfBirth, and sex")
    public Map<String, Object> register(@RequestBody Map<String, Object> accountInfo) {
        Map<String,Object> userMap = new HashMap<>();

        String username = (String) accountInfo.get("username");
        String password = (String) accountInfo.get("password");
        String dateOfBirthString = (String) accountInfo.get("dateOfBirth");
        String sexString = (String) accountInfo.get("sex");

        Boolean sex = null;
        Date dateOfBirth = null;

        if (sexString != null && sexString.length() != 0) {
            sex = Boolean.parseBoolean(sexString);
        }

        if (dateOfBirthString != null && dateOfBirthString.length() != 0) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateOfBirthDate = null;
            try {
                dateOfBirthDate = format.parse(dateOfBirthString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dateOfBirth = new Date(dateOfBirthDate.getTime());
        }

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            userMap.put("msg", "empty username or password");
            return userMap;
        }
        User userWithInputUsername = userService.getUserByName(username);
        if (userWithInputUsername != null) {
            userMap.put("msg", "username already exists");
            return userMap;
        }
        userService.insertUser(username, password, dateOfBirth, sex);
        userMap.put("msg", "successfully registered");
        return userMap;
    }

    @PostMapping(value = "/test")
    public String test(@RequestBody Map<String, Object> accountInfo){
        String username = (String) accountInfo.get("username");
        String password = (String) accountInfo.get("password");
        String dateOfBirthString = (String) accountInfo.get("dateOfBirth");
        String sexString = (String) accountInfo.get("sex");
        Boolean sex = Boolean.parseBoolean(sexString);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateOfBirthDate = null;
        try {
            dateOfBirthDate = format.parse(dateOfBirthString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateOfBirth = new Date(dateOfBirthDate.getTime());
        return password;
    }
}
