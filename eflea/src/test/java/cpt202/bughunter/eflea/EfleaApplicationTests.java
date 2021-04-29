package cpt202.bughunter.eflea;

import cpt202.bughunter.eflea.domain.User;
import cpt202.bughunter.eflea.mapper.UserMapper;
import cpt202.bughunter.eflea.service.UserService;
import cpt202.bughunter.eflea.web.UserController;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.RequestBuilder;

@SpringBootTest
class EfleaApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        User user = userService.toLogin("AAA","123");
        Assertions.assertEquals(false,user.getSex());
    }

}
