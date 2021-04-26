package cpt202.bughunter.eflea;

import cpt202.bughunter.eflea.domain.Product;
import cpt202.bughunter.eflea.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
class EfleaApplicationTests {


        @Autowired
        private ProductMapper productMapper1;

        @Test
        @Rollback
        public void test() throws Exception {



    }
}
