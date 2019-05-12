
package com.njoroge.fis.service.city.distance;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
public interface CityService {

    double getDistanceBetweenTowCities( DistanceBetweenCitiesRequest request );


    DistanceBetweenCitiesInitialData getInitialData();

}
