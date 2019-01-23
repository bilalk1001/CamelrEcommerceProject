package com.camelr.bilal.camelrecommerceproject.Models;

public class ATM {

    private String atmId;
    private String title;
    private String address;
    private String type;
    private double lat;
    private double lon;
    private String onlineStatus;

    // Empty constructor

    public ATM() {

    }

    public ATM(String atmId, String title, String address, String type, double lat, double lon, String onlineStatus) {
        this.atmId = atmId;
        this.title = title;
        this.address = address;
        this.type = type;
        this.lat = lat;
        this.lon = lon;
        this.onlineStatus = onlineStatus;
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

}
