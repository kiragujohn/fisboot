package com.njoroge.fis.helper;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
import org.springframework.beans.factory.annotation.Value;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */

import org.springframework.stereotype.Component;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import com.njoroge.fis.domain.City;

@Component
public class DistanceHelperImpl implements
        DistanceHelper {

    @Value( "${com.googlemaps.fisAPIKey}" )
    protected String key;

    static DistanceMatrix result;


    @Override
    public double getGoogleMapDistance( City city1, City city2 ) {

        String[] origin= {city1.getAddress()};
        String[] destination = { city2.getAddress() };

        GeoApiContext context = new GeoApiContext().setApiKey( key );

        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest( context );

        try {

            result = req.origins( origin ).destinations( destination ).mode(
                    TravelMode.DRIVING ).language( "en-US" ).await();
        }
        catch ( Exception e ) {

            e.printStackTrace();
        }

        return result.rows[0].elements[0].distance.inMeters;
    }


    @Override
    public double getMathFormulatedDistance( City city1, City city2 ) {

        double city1Latitude = city1.getLatitude();
        double city1Longitude = city1.getLongitude();
        double city2Latitude = city2.getLatitude();
        double city2Longitude = city2.getLongitude();

        if ( ( city1Latitude == city2Latitude )
                && ( city1Longitude == city2Longitude ) ) {

            return 0;
        }
        else {

            double theta = city1Longitude - city2Longitude;
            double dist = Math.sin( Math.toRadians( city1Latitude ) ) * Math
                    .sin( Math.toRadians( city2Latitude ) ) + Math.cos( Math
                            .toRadians( city1Latitude ) ) * Math.cos( Math
                                    .toRadians( city2Latitude ) ) * Math.cos(
                                            Math.toRadians( theta ) );

            dist = Math.acos( dist );
            dist = Math.toDegrees( dist );
            dist = dist * 60 * 1.1515;

            return ( dist * 1.609344 );
        }
    }

}
