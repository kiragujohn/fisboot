
package com.njoroge.fis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
@Entity
@Table( name = "CITY" )
public class City {

    @Column( name = "ADDRESS", nullable = false, unique = true, length = 255 )
    private String address;

    @Column( name = "LATITUDE", nullable = false, unique = false, length = 255 )
    private Double latitude;

    @Column( name = "LONGITUDE", nullable = false, unique = false,
            length = 255 )
    private Double longitude;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;


    public String getAddress() {

        return address;
    }


    public void setAddress( String address ) {

        this.address = address;
    }


    public Double getLatitude() {

        return latitude;
    }


    public void setLatitude( Double latitude ) {

        this.latitude = latitude;
    }


    public Double getLongitude() {

        return longitude;
    }


    public void setLongitude( Double longitude ) {

        this.longitude = longitude;
    }


    public Long getId() {

        return id;
    }


    public void setId( Long id ) {

        this.id = id;
    }


    @Override
    public String toString() {

        return "CITY [name=" + address + ", latitude=" + latitude
                + ", longitude=" + longitude + ", toString()="
                + super.toString() + "]";
    }
}
