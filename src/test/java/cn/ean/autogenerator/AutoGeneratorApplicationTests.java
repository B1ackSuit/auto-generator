package cn.ean.autogenerator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutoGeneratorApplicationTests {

    @Test
    void contextLoads() {
        String userCurrentWorkingDirectory = System.getProperty("user.dir");
        System.out.println("user.dir: \n" + userCurrentWorkingDirectory);
    }

}
