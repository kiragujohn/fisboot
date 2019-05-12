
package com.njoroge.fis.service.city.distance;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
public class DistanceBetweenCitiesInitialData {

    public CityTransfer[] cities;


    public DistanceBetweenCitiesInitialData() {

        super();
    }


    public DistanceBetweenCitiesInitialData( CityTransfer[] cities ) {

        this.cities = cities;
    }


    public CityTransfer[] getCities() {

        return cities;
    }


    public void setCities( CityTransfer[] cities ) {

        this.cities = cities;
    }

}