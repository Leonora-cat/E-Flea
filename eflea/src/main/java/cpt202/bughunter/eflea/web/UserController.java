package cpt202.bughunter.eflea.web;

import cpt202.bughunter.eflea.domain.User;
import cpt202.bughunter.eflea.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "create a new account", notes = "username: required, password: required, email: not required, major: not required, dateOfBirth: not required, and sex: not required")
    @ApiResponses({@ApiResponse(code = 200, message = "successfully registered"), @ApiResponse(code = 400, message = "invalid parameters")})
    public Map<String, Object> register(@RequestBody Map<String, Object> accountInfo) {
        Map<String,Object> userMap = new HashMap<>();

        String username = (String) accountInfo.get("username");
        String password = (String) accountInfo.get("password");
        String email = (String) accountInfo.get("email");
        String major = (String) accountInfo.get("major");
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
        userService.insertUser(username, password, email, major, dateOfBirth, sex);
        userMap.put("msg", "successfully registered");
        return userMap;
    }

    @PutMapping(value = "/editEmail")
    @ApiOperation(value = "edit email", notes = "email: not required, userID: required")
    @ApiResponses({@ApiResponse(code = 200, message = "successfully updated"), @ApiResponse(code = 400, message = "invalid parameters")})
    public Map<String, Object> editEmail(@RequestBody Map<String, Object> emailID) {
        Map<String,Object> userMap = new HashMap<>();

        String email = (String) emailID.get("email");
        String userIDString = (String) emailID.get("userID");

        if (userIDString == null || userIDString.isEmpty()) {
            userMap.put("msg", "empty userID");
        }
        else {
            Long userID = Long.valueOf(userIDString);
            userService.updateEmail(email, userID);
            userMap.put("msg", "successfully updated");
        }

        return userMap;
    }

    @PutMapping(value = "/editMajor")
    @ApiOperation(value = "edit major", notes = "major: not required, userID: required")
    @ApiResponses({@ApiResponse(code = 200, message = "successfully updated"), @ApiResponse(code = 400, message = "invalid parameters")})
    public Map<String, Object> editMajor(@RequestBody Map<String, Object> majorID) {
        Map<String,Object> userMap = new HashMap<>();

        String major = (String) majorID.get("major");
        String userIDString = (String) majorID.get("userID");

        if (userIDString == null || userIDString.isEmpty()) {
            userMap.put("msg", "empty userID");
        }
        else {
            Long userID = Long.valueOf(userIDString);
            userService.updateMajor(major, userID);
            userMap.put("msg", "successfully updated");
        }

        return userMap;
    }

    @PutMapping(value = "/editDateOfBirth")
    @ApiOperation(value = "edit dateOfBirth", notes = "dateOfBirth: not required, userID: required")
    @ApiResponses({@ApiResponse(code = 200, message = "successfully updated"), @ApiResponse(code = 400, message = "invalid parameters")})
    public Map<String, Object> editDateOfBirth(@RequestBody Map<String, Object> birthID) {
        Map<String,Object> userMap = new HashMap<>();

        String dateOfBirthString = (String) birthID.get("dateOfBirth");
        String userIDString = (String) birthID.get("userID");

        Date dateOfBirth = null;

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

        if (userIDString == null || userIDString.isEmpty()) {
            userMap.put("msg", "empty userID");
        }
        else {
            Long userID = Long.valueOf(userIDString);
            userService.updateDateOfBirth(dateOfBirth, userID);
            userMap.put("msg", "successfully updated");
        }

        return userMap;
    }

    @PutMapping(value = "/editSex")
    @ApiOperation(value = "edit sex", notes = "sex: not required, userID: required")
    @ApiResponses({@ApiResponse(code = 200, message = "successfully updated"), @ApiResponse(code = 400, message = "invalid parameters")})
    public Map<String, Object> editSex(@RequestBody Map<String, Object> sexID) {
        Map<String,Object> userMap = new HashMap<>();

        String sexString = (String) sexID.get("sex");
        String userIDString = (String) sexID.get("userID");

        Boolean sex = null;

        if (sexString != null && sexString.length() != 0) {
            sex = Boolean.parseBoolean(sexString);
        }

        if (userIDString == null || userIDString.isEmpty()) {
            userMap.put("msg", "empty userID");
        }
        else {
            Long userID = Long.valueOf(userIDString);
            userService.updateSex(sex, userID);
            userMap.put("msg", "successfully updated");
        }

        return userMap;
    }

}
