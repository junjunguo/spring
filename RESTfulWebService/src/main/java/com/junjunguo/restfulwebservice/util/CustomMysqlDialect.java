package com.junjunguo.restfulwebservice.util;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * This file is part of restfulwebservice.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 27/10/2016.
 */

public class CustomMysqlDialect extends MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
