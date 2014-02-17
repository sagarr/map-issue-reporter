package com.rohankar.playground.bean;

/**
 * @author Sagar Rohankar
 */
public class Report {

    private String id;
    private Coordinates coordinates;
    private String anomalyType;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(final Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getAnomalyType() {
        return anomalyType;
    }

    public void setAnomalyType(final String anomalyType) {
        this.anomalyType = anomalyType;
    }

}
