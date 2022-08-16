package com.sun.config;

import com.sun.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private final static SessionFactory FACTORY ;
    static{
        Configuration config  =  new Configuration();
        config
                .setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver")
                .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/demo")
                .setProperty("hibernate.connection.username","root")
                .setProperty("hibernate.connection.password","Huyen.26122001")
                .setProperty("hibernate.show_sql","true")
                .setProperty("hibernate.hbm2ddl.auto","create-drop")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Histories.class)
                .addAnnotatedClass(HistoryDetail.class)
                .addAnnotatedClass(Type.class)
                .addAnnotatedClass(TypeBook.class)
                ;
        FACTORY = config.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return FACTORY;
    }
}
