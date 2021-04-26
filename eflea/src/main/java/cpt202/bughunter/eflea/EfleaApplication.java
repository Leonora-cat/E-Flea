package cpt202.bughunter.eflea;


import cpt202.bughunter.eflea.domain.Product;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cpt202.bughunter.eflea.mapper")
public class EfleaApplication {

    public static void main(String[] args) {

        SpringApplication.run(EfleaApplication.class, args);



        
    }

}
