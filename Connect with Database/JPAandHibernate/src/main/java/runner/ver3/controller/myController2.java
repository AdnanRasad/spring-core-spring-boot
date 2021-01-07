package runner.ver3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import runner.ver3.dao.database2;
import runner.ver3.model.myusers2;

import java.util.List;

@RestController
public class myController2  {

    @Autowired
   database2 database;

    @RequestMapping("/getAllUsersSpringDataJpa")
    public List<myusers2> getUsersJPA(){
        return database.findAll();

    }



}
