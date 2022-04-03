package com.jumbo.supermatten.service;

public interface HaversineService {

  public Integer getDistance(Double lat1, Double lon1, Double lat2, Double lon2);

  public  Double toRad(Double value) ;
}
