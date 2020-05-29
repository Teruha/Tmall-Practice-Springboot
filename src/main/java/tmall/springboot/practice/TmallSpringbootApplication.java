package tmall.springboot.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TmallSpringbootApplication {

    static{
        PortUtil.checkPort(6379, "Redis Server", true);
        // 配置使用Redis

    }

    public static void main(String[] args) {
        SpringApplication.run(TmallSpringbootApplication.class, args);
    }

}
