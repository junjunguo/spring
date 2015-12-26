package com.junjunguo.spring.thymeleaf.data;

import com.junjunguo.spring.thymeleaf.model.Spitter;

public interface SpitterRepository {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);

}
