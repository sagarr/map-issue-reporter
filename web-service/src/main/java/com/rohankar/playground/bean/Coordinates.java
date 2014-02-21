package com.rohankar.playground.bean;


/**
 * @author Sagar Rohankar
 */
public class Coordinates {

    private double longitude;
    private double latitude;

    public Coordinates(final double lon, final double lat) {
        longitude = lon;
        latitude = lat;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(final double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(final double latitude) {
        this.latitude = latitude;
    }
}
