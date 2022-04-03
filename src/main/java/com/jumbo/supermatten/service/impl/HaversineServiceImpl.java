package com.jumbo.supermatten.service.impl;

import com.jumbo.supermatten.service.HaversineService;
import org.springframework.stereotype.Service;

@Service
public class HaversineServiceImpl implements HaversineService {

  @Override
  public Integer getDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
    final int RADIUS_OF_THE_EARTH = 6371;
    Double latDistance = toRad(lat2-lat1);
    Double lonDistance = toRad(lon2-lon1);
    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
        Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
            Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    double distance = RADIUS_OF_THE_EARTH * c;
    return (int) distance;
  }

  @Override
  public Double toRad(Double value) {
      return value * Math.PI / 180;
  }
}
