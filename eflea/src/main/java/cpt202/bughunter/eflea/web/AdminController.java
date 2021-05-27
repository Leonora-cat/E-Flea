package cpt202.bughunter.eflea.web;

import cpt202.bughunter.eflea.domain.Admin;
import cpt202.bughunter.eflea.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "Admin controller")
@RestController
@RequestMapping(value = "/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    @ApiOperation(value = "login", notes = "admin login")
    public  Map<String, Object> login(@RequestBody Admin admin) throws Exception {
        Map<String, Object> adminMap = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        Admin realAdmin;


        realAdmin = adminService.getAdminByNameAndPwd(admin.getUsername(), admin.getPassword());
        System.out.println("realAdmin" + realAdmin);
        System.out.println("adminName:" + admin.getUsername());
        System.out.println("password:" + admin.getPassword());

        if (realAdmin != null){
            adminMap.put("code", 20000);
            map.put("token", admin.getUsername() + "-token");

            adminMap.put("data",map);

            return adminMap;
        }
        adminMap.put("code", 403);
        adminMap.put("message","fail");
        return adminMap;
    }

    @GetMapping("/adminDetail")
    @ApiOperation(value = "getAdmin", notes = "admin details")
    public  Map<String, Object> getAdmin(@RequestParam String token) throws Exception {
        Map<String, Object> adminMap1 = new HashMap<>();
        Map<String, Object> map = new HashMap<>();

        Admin realAdmin1;

        realAdmin1 = adminService.getAdminByName(token.split("-")[0]);
        System.out.println(token.split("-")[0] + "  ok");

        System.out.println(realAdmin1);
        if(realAdmin1 != null){
            adminMap1.put("code", 20000);
            map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            map.put("introduction", "Administrator in eflea");
            map.put("name", token.split("-")[0]);
            String[] arr = {"admin"};
            map.put("roles", arr);
            adminMap1.put("data", map);

        }

        return adminMap1;

    }

    @PostMapping("/next")
    @ApiOperation(value = "next", notes = "admin detail")
    public  Admin next(@RequestBody String name) throws Exception {
        Admin realAdmin;

        name = name.substring(0, name.length() - 1);
        System.out.println("name: " + name);
        realAdmin = adminService.getAdminByName(name);
        System.out.println("realAdmin" + realAdmin);

        return realAdmin;
    }

    @GetMapping("/update{email}")
    @ApiOperation(value = "next", notes = "admin detail update")
    public void update(@PathVariable String email) throws Exception {
        System.out.println(email);
        adminService.update(email);


    }
}
