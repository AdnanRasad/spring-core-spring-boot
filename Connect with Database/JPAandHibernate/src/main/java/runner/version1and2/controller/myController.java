package runner.version1and2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import runner.version1and2.dao.database;
import runner.version1and2.model.myusers;

import java.util.List;

@RestController
public class myController {

    @RequestMapping("/")
    public String getReply(){
        return "Welcome <br> " +
                "<button><a href ='/getAllUsers' /> Get all users (Hiberate Implementation)</button> <br> " +
                "<button><a href ='/getAllUsersJPA' /> Get all users (JPA specification)</button> <br>"+
                "<button><a href ='/getAllUsersSpringDataJpa' /> Get all users (Spring Data JPA)</button>";

    }

    @Autowired
    database database; //we can use @Annotated for classes that are @Repository because @Repository is a specialization of @Component

    @RequestMapping("/getAllUsers")
    public List<myusers> getUsers(){
    return database.getAllUsers();

    }

    @RequestMapping("/getAllUsersJPA")
    public List<myusers> getUsersJPA(){
        return database.getAllUsersJPA();

    }


}
