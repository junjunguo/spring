package com.junjunguo.jwt.dao.daoImpl;

import com.junjunguo.jwt.dao.UserDao;
import com.junjunguo.jwt.model.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * This file is part of RESTFulWebSpringBootSecurityJWT.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 23/12/2016.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public void create(User user) {
        log("create ");
        try {
            entityManager.persist(user);
        } catch (Exception e){
            log("catch ");
            e.printStackTrace();
        }
    }

    public User update(User user) {
        return entityManager.merge(user);
    }

    public void deleteByEmail(String email) {
        entityManager.remove(findByEmail(email));
    }

    public User findByEmail(String email) {
        return entityManager.find(User.class, email);
    }

    public List<User> findByName(String name) {
        return entityManager.createQuery("select u from User u where u.username like :name", User.class)
                            .getResultList();
    }

    public void log(String s) {
        System.out.println(this.getClass().getSimpleName() + "................. " + s);
    }

}
