package com.junjunguo.spring.upload.data;

import com.junjunguo.spring.upload.model.Spitter;

public interface SpitterRepository {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);

}
