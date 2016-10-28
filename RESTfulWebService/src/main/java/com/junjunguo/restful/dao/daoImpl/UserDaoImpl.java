package com.junjunguo.restful.dao.daoImpl;

import com.junjunguo.restful.dao.UserDao;
import com.junjunguo.restful.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This file is part of restfulservice.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 27/10/2016.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {
    }

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<User> findAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
    }

    @Transactional
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Transactional
    public void deleteUserByEmail(String email) {
        sessionFactory.getCurrentSession().delete(findByEmail(email));
    }

    @Transactional
    public User findByEmail(String email) {
        Query q = sessionFactory.getCurrentSession().createQuery("from User where email = '" + email + "'", User.class);
        return !q.list().isEmpty() ? (User) q.list().get(0) : null;
    }

    @Transactional
    public User findByName(String name) {
        Query q = sessionFactory.getCurrentSession().createQuery("from User where name = '" + name + "'", User.class);
        return !q.list().isEmpty() ? (User) q.list().get(0) : null;
    }

    public void log(String s) {
        System.out.println(this.getClass().getSimpleName() + "................. " + s);
    }

}
