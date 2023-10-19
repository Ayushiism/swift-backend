package com.example.Swift_backend.Dto;

public class TheatreDTO {
    private String theaterName;
    private String theaterAddress;
    private long locationId;

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterAddress() {
        return theaterAddress;
    }

    public void setTheaterAddress(String theaterAddress) {
        this.theaterAddress = theaterAddress;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }
}

