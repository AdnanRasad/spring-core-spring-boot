package runner.version1and2.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import runner.version1and2.model.myusers;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class database {

    @Autowired
    EntityManager entityManager;



    //version 1: using hibernate implemetation
    @Transactional
    public List<myusers> getAllUsers(){

        Session session = entityManager.unwrap(Session.class);
        org.hibernate.query.Query<myusers> myusers_in_query = session.createQuery("from myusers ", myusers.class);
        return myusers_in_query.getResultList();

    }

    //version 2: using jpa specification
    @Transactional
    public List<myusers> getAllUsersJPA(){

        javax.persistence.Query theQuery = entityManager.createQuery("from myusers ");
        return theQuery.getResultList();

    }




}
