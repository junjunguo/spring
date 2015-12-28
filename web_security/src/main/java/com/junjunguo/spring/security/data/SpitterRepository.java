package com.junjunguo.spring.security.data;

import com.junjunguo.spring.security.Spitter;

public interface SpitterRepository {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);

}
