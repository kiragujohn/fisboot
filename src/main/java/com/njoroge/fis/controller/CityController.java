
package com.njoroge.fis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.njoroge.fis.service.city.distance.CityService;
import com.njoroge.fis.service.city.distance.DistanceBetweenCitiesInitialData;
import com.njoroge.fis.service.city.distance.DistanceBetweenCitiesRequest;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
@RestController
@RequestMapping( "/fis/city" )
public class CityController {

    @Autowired
    CityService cityService;


    @RequestMapping( value = "/findcitiesinitialdata",
            method = RequestMethod.GET )
    public ResponseEntity<DistanceBetweenCitiesInitialData>
            findCitiesInitialData() {

        DistanceBetweenCitiesInitialData distanceBetweenCitiesInitialData =
                cityService.getInitialData();

        return ResponseEntity.status( HttpStatus.OK ).body(
                distanceBetweenCitiesInitialData );
    }


    @RequestMapping( value = "/finddistancebetweencities",
            method = RequestMethod.POST )
    public ResponseEntity<Double> findDistanceBetweenCities(
            @RequestBody DistanceBetweenCitiesRequest request ) {

        double distance = cityService
                .getDistanceBetweenTowCities( request );

        return ResponseEntity.status( HttpStatus.OK ).body(
                distance );
    }

}
