package com.junjunguo.spring.upload.data;

import com.junjunguo.spring.upload.model.Spittle;

import java.util.List;

public interface SpittleRepository {

  List<Spittle> findRecentSpittles();

  List<Spittle> findSpittles(long max, int count);
  
  Spittle findOne(long id);

  void save(Spittle spittle);

}
