package com.njoroge.fis.helper;

import com.njoroge.fis.domain.City;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */

public interface DistanceHelper {

    public double getGoogleMapDistance( City city1, City city2 );


    public double getMathFormulatedDistance( City city1, City city2 );

}
