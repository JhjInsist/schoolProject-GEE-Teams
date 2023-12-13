package cn.edu.dlpulyt.keshe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.edu.dlpulyt.keshe.mapper")
public class KesheApplication {

    public static void main(String[] args) {
        SpringApplication.run(KesheApplication.class, args);
    }

}
