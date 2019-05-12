
package com.njoroge.fis.service.city.distance;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
public class CityTransfer {

    private Long id;
    private String address;
    private double latitude;
    private double longitude;


    public CityTransfer() {

        super();
    }


    public CityTransfer( Long id, String address, double latitude,
            double longitude ) {

        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public Long getId() {

        return id;
    }


    public void setId( Long id ) {

        this.id = id;
    }


    public String getAddress() {

        return address;
    }


    public void setAddress( String address ) {

        this.address = address;
    }


    public double getLatitude() {

        return latitude;
    }


    public void setLatitude( double latitude ) {

        this.latitude = latitude;
    }


    public double getLongitude() {

        return longitude;
    }


    public void setLongitude( double longitude ) {

        this.longitude = longitude;
    }


}
