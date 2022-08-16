package com.sun.repository;

import com.sun.config.HibernateUtil;
import com.sun.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserRepository {
    private Session session;
    private Transaction transaction;

    public List<User> getAll(){
        List<User> users = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // FROM
            String hql = "FROM Users";
            Query query = session.createQuery(hql);
            List results = query.list();
            for (Iterator iterator = results.iterator(); iterator.hasNext();){
                User u = (User) iterator.next();
                System.out.println(u.getId()+" "+u.getEmail()+" "+u.getName());
                users.add(u);
            }
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return users;
    }
}
