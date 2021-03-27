package cpt202.bughunter.eflea.web;

import cpt202.bughunter.eflea.domain.User;
import cpt202.bughunter.eflea.service.UserService;
import cpt202.bughunter.eflea.util.CipherUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private boolean cipherOn = false;
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "login", notes = "receive username and password, if the user exists, return all the info")
    public Map<String, Object> toLogin(@RequestBody User user) throws Exception {
        Map<String, Object> userMap = new HashMap<>();
        User realUser;
        if (cipherOn) {
            realUser = userService.toLogin(user.getUsername(), CipherUtil.encrypt(user.getPassword()));
        } else {
            realUser = userService.toLogin(user.getUsername(), user.getPassword());
        }
        if (realUser != null) {
            userMap.put("status", "success");
            userMap.put("userInfo", realUser);
        } else {
            userMap.put("status", "error");
        }
        return userMap;
    }

    @PostMapping(value = "/register")
    @ApiOperation(value = "register a new account", notes = "require username, password, dateOfBirth, and sex")
    public Map<String, Object> register(@RequestBody Map<String, Object> accountInfo) {
        Map<String, Object> userMap = new HashMap<>();

        String username = (String) accountInfo.get("username");
        String password = (String) accountInfo.get("password");
        String email = (String) accountInfo.get("email");
        String dateOfBirthString = (String) accountInfo.get("year") + "-" + accountInfo.get("month") + "-" + accountInfo.get("day");
        String sexString = (String) accountInfo.get("sex");
        System.out.println(dateOfBirthString);
        Boolean sex = null;
        Date dateOfBirth = null;

        if (sexString != null && sexString.length() != 0) {
            sex = Boolean.parseBoolean(sexString);
        }

        if (dateOfBirthString.length() != 0) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateOfBirthDate = null;
            try {
                dateOfBirthDate = format.parse(dateOfBirthString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dateOfBirth = new Date(dateOfBirthDate.getTime());
        }
        System.out.println(dateOfBirth);

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            userMap.put("msg", "empty username or password");
            return userMap;
        }
        User userWithInputUsername = userService.getUserByName(username);
        if (userWithInputUsername != null) {
            userMap.put("msg", "username already exists");
            return userMap;
        }
        userService.insertUser(username, password, email, dateOfBirth, sex);
        userMap.put("msg", "successfully registered");
        return userMap;
    }

    @PostMapping("/resetPassword")
    @ApiOperation(value = "resetPassword", notes = "if user forgets his password, he can reset his password using username and email")
    public String resetPassword(@RequestBody User user) throws Exception {
        return userService.resetPassword(user.getUsername(), user.getEmail(), user.getPassword());
    }
}
