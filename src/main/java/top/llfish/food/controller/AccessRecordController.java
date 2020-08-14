package top.llfish.food.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;


@RestController
@RequestMapping("/Acccess")
public class AccessRecordController {

    @PersistenceContext
    private EntityManager em;

    @GetMapping("/access_once")
    public int AccessOnce(String name){
        Integer accessCount = 0;
        Date date = new Date(System.currentTimeMillis());
        Query query = em.createNativeQuery("call AccessOnce(?, ?)");
        query.setParameter(1, date);
        query.setParameter(2, name);
        accessCount = (Integer) query.getSingleResult();
        return accessCount;
    }
}
