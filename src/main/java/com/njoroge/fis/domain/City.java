
package com.njoroge.fis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
@Entity
@Table( name = "city" )
public class City extends AbstractPersistentEntity {

    private static final long serialVersionUID = 5222806659166236835L;

    @Column( name = "address", nullable = false, unique = true, length = 255 )
    private String address;

    @Column( name = "latitude", nullable = false, unique = false, length = 255 )
    private Double latitude;

    @Column( name = "longitude", nullable = false, unique = false,
            length = 255 )
    private Double longitude;


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


    @Override
    public String toString() {

        return "CITY [name=" + address + ", latitude=" + latitude
                + ", longitude=" + longitude + ", toString()="
                + super.toString() + "]";
    }
}
