package com.fermin2049.exploradordefarmacias.model;

import java.io.Serializable;

public class Pharmacy implements Serializable {
    private String name;
    private String address;
    private String gpsAddress;
    private String phone;
    private String email;
    private String website;
    private String schedule;
    private String services;
    private int image;

    public Pharmacy(String name, String address, String gpsAddress, String phone, String email, String website, String schedule, String services, int image) {
        this.name = name;
        this.address = address;
        this.gpsAddress = gpsAddress;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.schedule = schedule;
        this.services = services;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGpsAddress() {
        return gpsAddress;
    }

    public void setGpsAddress(String gpsAddress) {
        this.gpsAddress = gpsAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
