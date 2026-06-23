package com.tourism.tourism_app.model;

public class Tourist {
    private int id;
    private String name;
    private String city;
    private String packageType;
    private double budget;

    // Constructors
    public Tourist() {}

    public Tourist(int id, String name, String city, String packageType, double budget) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.packageType = packageType;
        this.budget = budget;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    // toString() for debugging
    @Override
    public String toString() {
        return "Tourist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", packageType='" + packageType + '\'' +
                ", budget=" + budget +
                '}';
    }
}
