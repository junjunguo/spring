package com.junjunguo.jwt.service.serviceImpl;

import com.junjunguo.jwt.dao.UserDao;
import com.junjunguo.jwt.model.entity.User;
import com.junjunguo.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This file is part of restfulservice.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 27/10/2016.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public List<User> findByName(String name) {
        return userDao.findByName(name);
    }

    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       return userDao.create(user);
    }

    public User update(User c, User u) {
        if (u == null || u.getEmail() == null) {
            return null;
        }
        return userDao.update(c.updateUser(c, u));
    }

    public void deleteByEmail(String email) {
        userDao.deleteByEmail(email);
    }

    public boolean isExist(String email) {
        return findByEmail(email) != null;
    }

    @Override public void changePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.update(user);
    }
}
