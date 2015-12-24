package com.junjunguo.spring.mvc.data;

import com.junjunguo.spring.mvc.model.Spitter;

public interface SpitterRepository {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);

}
