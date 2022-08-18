package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LocationGps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Employees employee;
    private double latitude;
    private double longitude;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employees getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocationGps() {
    }

    public LocationGps(Long id, Employees employee, double latitude, double longitude) {
        this.id = id;
        this.employee = employee;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocationGps(Employees employee, double latitude, double longitude) {
        this.employee = employee;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
