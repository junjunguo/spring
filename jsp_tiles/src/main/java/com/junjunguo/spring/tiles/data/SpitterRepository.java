package com.junjunguo.spring.tiles.data;

import com.junjunguo.spring.tiles.Spitter;

public interface SpitterRepository {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);

}
