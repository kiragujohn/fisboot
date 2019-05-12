
package com.njoroge.fis.service.city.distance;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
public class DistanceBetweenCitiesRequest {

    private long city1Id;
    private long city2Id;
    private long speed;


    public DistanceBetweenCitiesRequest() {

    }


    public DistanceBetweenCitiesRequest( long city1Id, long city2Id,
            long speed ) {

        this.city1Id = city1Id;
        this.city2Id = city2Id;
        this.speed = speed;
    }


    public long getSpeed() {

        return speed;
    }


    public void setSpeed( long speed ) {

        this.speed = speed;
    }


    public long getCity1Id() {

        return city1Id;
    }


    public void setCity1Id( long city1Id ) {

        this.city1Id = city1Id;
    }


    public long getCity2Id() {

        return city2Id;
    }


    public void setCity2Id( long city2Id ) {

        this.city2Id = city2Id;
    }
}
