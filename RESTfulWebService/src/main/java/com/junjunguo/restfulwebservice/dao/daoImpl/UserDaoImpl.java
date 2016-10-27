package com.junjunguo.restfulwebservice.dao.daoImpl;

import com.junjunguo.restfulwebservice.dao.UserDao;
import com.junjunguo.restfulwebservice.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This file is part of restfulwebservice.
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
        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
                                                         .createCriteria(User.class)
                                                         .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return listUser;
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
        Query q = sessionFactory.getCurrentSession().createQuery("from User where email = '" + email + "'");
        return !q.list().isEmpty() ? (User) q.list().get(0) : null;
    }


    @Transactional
    public User findByName(String name) {
        Query q = sessionFactory.getCurrentSession().createQuery("from User where name = '" + name + "'");
        return !q.list().isEmpty() ? (User) q.list().get(0) : null;
    }
}
