package com.junjunguo.spring.mvc.model;

import java.util.Date;
import java.util.Objects;

public class Spittle {

  private final Long id;
  private final String message;
  private final Date time;
  private Double latitude;
  private Double longitude;

  public Spittle(String message, Date time) {
    this(null, message, time, null, null);
  }
  
  public Spittle(Long id, String message, Date time, Double longitude, Double latitude) {
    this.id = id;
    this.message = message;
    this.time = time;
    this.longitude = longitude;
    this.latitude = latitude;
  }

  public long getId() {
    return id;
  }

  public String getMessage() {
    return message;
  }

  public Date getTime() {
    return time;
  }
  
  public Double getLongitude() {
    return longitude;
  }
  
  public Double getLatitude() {
    return latitude;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Spittle)) return false;
    Spittle spittle = (Spittle) o;
    return Objects.equals(getId(), spittle.getId()) &&
           Objects.equals(getMessage(), spittle.getMessage()) &&
           Objects.equals(getTime(), spittle.getTime()) &&
           Objects.equals(getLatitude(), spittle.getLatitude()) &&
           Objects.equals(getLongitude(), spittle.getLongitude());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getMessage(), getTime(), getLatitude(), getLongitude());
  }
}
