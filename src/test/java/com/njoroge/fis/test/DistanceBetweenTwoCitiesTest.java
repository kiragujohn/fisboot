package com.njoroge.fis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElementStatus;
import com.njoroge.fis.domain.City;
import com.njoroge.fis.helper.DistanceHelper;

public class DistanceBetweenTwoCitiesTest {

    @Value( "${com.googlemaps.fisAPIKey}" )
    protected String key;

    @Autowired
    private DistanceHelper distanceBetweenTwoCities;


    public DistanceBetweenTwoCitiesTest() {

    }

    private static final double DELTA = 1e-15;


    @Test
    public void testGetDistanceMathFormulated() throws Exception {

        City city1 = new City();
        City city2 = new City();
        city1.setLatitude( -29.883333 );
        city1.setLongitude( 31.049999 );

        city2.setLatitude( -25.747868 );
        city2.setLongitude( 28.229271 );

        double expected = distanceBetweenTwoCities.getMathFormulatedDistance(
                city1, city2 );

        assertEquals( 536.953385833239, expected, DELTA );
    }


    @Test
    public void testGetDistanceMatrixWithBasicStringParams() throws Exception {

        GeoApiContext context = new GeoApiContext().setApiKey( key );

        try {

            String[] origins = new String[] { "Durban, South Africa" };
            String[] destinations = new String[] { "Pretoria, South Africa" };

            DistanceMatrix matrix = DistanceMatrixApi.getDistanceMatrix(
                    context, origins, destinations ).await();

            assertNotNull( matrix.toString() );
            assertNotNull( Arrays.toString( matrix.rows ) );

            assertEquals( 1, matrix.rows.length );
            assertEquals( DistanceMatrixElementStatus.OK,
                    matrix.rows[0].elements[0].status );

            assertEquals( "Durban, South Africa", matrix.originAddresses[0] );
        }
        catch ( Exception e ) {

            e.printStackTrace();
        }
    }
}
