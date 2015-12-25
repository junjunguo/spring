package com.junjunguo.spring.jsp.data;

import com.junjunguo.spring.jsp.model.Spitter;

public interface SpitterRepository {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);

}
