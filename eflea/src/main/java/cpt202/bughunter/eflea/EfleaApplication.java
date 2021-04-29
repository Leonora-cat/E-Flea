package cpt202.bughunter.eflea;


import cpt202.bughunter.eflea.util.CipherUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class EfleaApplication {

    public static void main(String[] args){
        SpringApplication.run(EfleaApplication.class, args);
//        System.out.println(CipherUtil.encrypt("123"));
//        System.out.println(CipherUtil.desEncrypt("sO4BNetaaYxyo8CQANuSVg=="));
    }

}
