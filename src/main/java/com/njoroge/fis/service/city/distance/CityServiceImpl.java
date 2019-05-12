
package com.njoroge.fis.service.city.distance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njoroge.fis.domain.City;
import com.njoroge.fis.helper.DistanceHelper;
import com.njoroge.fis.repository.CityRepository;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistanceHelper distanceHelper;

    static final long BREAK_DURATION = 20;


    private CityTransfer[] getCityTransfers( List<City> cities ) {

        List<CityTransfer> cityTransfers = new ArrayList<>();

        for ( City city : cities ) {
            CityTransfer userTransfer = new CityTransfer();
            userTransfer.setId( city.getId() );
            userTransfer.setAddress( city.getAddress() );
            userTransfer.setLatitude( city.getLatitude() );
            userTransfer.setLongitude( city.getLongitude() );
            cityTransfers.add( userTransfer );
        }

        return cityTransfers.toArray( new CityTransfer[cityTransfers.size()] );
    }


    private double getTotalTimeInMinutes( double travelHrs ) {

        double travelTimeInMinutes = travelHrs * 60;

        double breakTimeInMinutes = Math.floor( travelHrs / 2 ) * 20;

        double travelTimeAndBreakInMinutes = travelTimeInMinutes
                + breakTimeInMinutes;

        return travelTimeAndBreakInMinutes;
    }


    private double getEstimatedTravelTime( double distance,
            double speed ) {

        double travelHrs = distance / speed;

        double totalTravelTimeInMinute = getTotalTimeInMinutes( travelHrs );

        return totalTravelTimeInMinute;
    }


    @Override
    public DistanceBetweenCitiesInitialData getInitialData() {

        DistanceBetweenCitiesInitialData distanceBetweenCitiesInitialData =
                new DistanceBetweenCitiesInitialData();

        List<City> cities = cityRepository.findAll();

        distanceBetweenCitiesInitialData.cities = getCityTransfers( cities );

        return distanceBetweenCitiesInitialData;
    }


    @Override
    public double getDistanceBetweenTowCities(
            DistanceBetweenCitiesRequest request ) {

        City city1 = cityRepository.findOne( request.getCity1Id() );
        City city2 = cityRepository.findOne( request.getCity2Id() );
        double travelTimeInMinutes = 0;

        // I wanted to use this api because it is more accurate and a good one
        // to demo but google gives me a very limited number of requests to the
        // API
        // double distanceFromGoogleApi = distanceHelper.getGoogleMapDistance(
        // city1, city2 );

        double distanceFromMathFormula = distanceHelper
                .getMathFormulatedDistance( city1, city2 );

        travelTimeInMinutes = getEstimatedTravelTime( distanceFromMathFormula,
                request.getSpeed() );


        return ( travelTimeInMinutes / 60 );
    }

}
