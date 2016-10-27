package com.junjunguo.restfulwebservice.configuration;

import com.junjunguo.restfulwebservice.dao.UserDao;
import com.junjunguo.restfulwebservice.dao.daoImpl.UserDaoImpl;
import com.junjunguo.restfulwebservice.model.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * This file is part of restfulwebservice.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 27/10/2016.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({"com.junjunguo.restfulwebservice.configuration"})
public class HibernateConfiguration {
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/restfulwebservice?autoReconnect=true&useSSL=false");
        dataSource.setUsername("junjunguo");
        dataSource.setPassword("password");
        return dataSource;
    }

    /**
     * <h1>Hibernate Configuration Properties:</h1>
     * <p>
     * <h2>hibernate.order_updates</h2> <b>"true | false"</b>. Forces Hibernate to order SQL updates by the primary key
     * value of the items being updated. This will result in fewer transaction deadlocks in highly concurrent systems.
     * <p>
     * <h2>hibernate.show_sql</h2> e.g. <b>"true | false"</b>. Write all SQL statements to console. This is an
     * alternative to setting the log category org.hibernate.SQL to debug.
     * <p>
     * <h2>hibernate.format_sql</h2> e.g. <b>"true | false"</b>.	Pretty print the SQL in the log and console.
     * <p>
     * <h2>hibernate.hbm2ddl.auto</h2>  <b> "validate | update | create | create-drop" </b>. Automatically validates or
     * exports schema DDL to the database when the SessionFactory is created. With create-drop, the database schema will
     * be dropped when the SessionFactory is closed explicitly. e.g.
     * <p>
     * <h2>SQL Dialects</h2>  <b>"org.hibernate.dialect.Dialect"</b>. Always set the hibernate.dialect property to the
     * correct <b>org.hibernate.dialect.Dialect</b> subclass for your database. If you specify a dialect, Hibernate will
     * use sensible defaults for some of the other properties listed above. This means that you will not have to specify
     * them manually.
     */
    private Properties getHibernateProperties() {

        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.order_updates", "true");
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.dialect", "com.junjunguo.restfulwebservice.util.CustomMysqlDialect");
        return properties;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(getHibernateProperties());
        sessionBuilder.addAnnotatedClasses(User.class);
        return sessionBuilder.buildSessionFactory();
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory) {
        return new HibernateTransactionManager(
                sessionFactory);
    }

    @Autowired
    @Bean(name = "userDao")
    public UserDao getUserDao(SessionFactory sessionFactory) {
        return new UserDaoImpl(sessionFactory);
    }

}
