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
    String myRoot(){return "hi user! its root page <button><a href='/home'/>Go to Home</button> <button><a href='/admin'/>Go to Admin</button>" ;}

    @RequestMapping("/home")
    String myHome(){return "hi user! its home page <button><a href='/'/>Go to Root</button>  <button><a href='/logout'/>Logout</button>" ;}

    @RequestMapping("/admin")
    String mygetter(){return "hi user! its admin page <button><a href='/'/>Go to Root</button>  <button><a href='/logout'/>Logout</button>";}

}
