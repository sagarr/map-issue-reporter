package com.rohankar.playground.bean;

/**
 * @author Sagar Rohankar
 */
public class AnomalyReport {

    private int id;
    private Coordinates coordinates;
    private String anomalyType;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
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
