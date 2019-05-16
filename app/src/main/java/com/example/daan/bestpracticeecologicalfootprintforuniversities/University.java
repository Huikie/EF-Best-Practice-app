package com.example.daan.bestpracticeecologicalfootprintforuniversities;

public class University {
    private String name, location, research, continent, population, year, ef, efpc, energy, mobility, waste, paper, food, built_land, water;


    public University(String name, String location, String research, String continent, String population, String year, String ef, String efpc, String energy, String mobility, String waste, String paper, String food, String built_land, String water) {
        this.name = name;
        this.location = location;
        this.research = research;
        this.continent = continent;
        this.population = population;
        this.year = year;
        this.ef = ef;
        this.efpc = efpc;
        this.energy = energy;
        this.mobility = mobility;
        this.waste = waste;
        this.paper = paper;
        this.food = food;
        this.built_land = built_land;
        this.water = water;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEf() {
        return ef;
    }

    public void setEf(String ef) {
        this.ef = ef;
    }

    public String getEfpc() {
        return efpc;
    }

    public void setEfpc(String efpc) {
        this.efpc = efpc;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getMobility() {
        return mobility;
    }

    public void setMobility(String mobility) {
        this.mobility = mobility;
    }

    public String getWaste() {
        return waste;
    }

    public void setWaste(String waste) {
        this.waste = waste;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getBuilt_land() {
        return built_land;
    }

    public void setBuilt_land(String built_land) {
        this.built_land = built_land;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }
}
