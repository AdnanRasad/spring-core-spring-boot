package code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class runner {



    public static void main(String args []){
        SpringApplication.run(runner.class, args);
    }

    @RequestMapping("/")
    String mygetter(){return "hi!";}


}
