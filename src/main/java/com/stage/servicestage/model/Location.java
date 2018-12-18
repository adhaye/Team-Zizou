package com.internsheep.blog.Model;

public class Location {

    private int IDLocation;
    private String CountryLocation;
    private String CityLocation;
    private String RegionLocation;
    private String DetailsLocation;

    public Location(int IDLocation, String countryLocation, String cityLocation, String regionLocation, String detailsLocation) {
        this.IDLocation = IDLocation;
        CountryLocation = countryLocation;
        CityLocation = cityLocation;
        RegionLocation = regionLocation;
        DetailsLocation = detailsLocation;
    }

    public int getIDLocation() {
        return IDLocation;
    }

    public void setIDLocation(int IDLocation) {
        this.IDLocation = IDLocation;
    }

    public String getCountryLocation() {
        return CountryLocation;
    }

    public void setCountryLocation(String countryLocation) {
        CountryLocation = countryLocation;
    }

    public String getCityLocation() {
        return CityLocation;
    }

    public void setCityLocation(String cityLocation) {
        CityLocation = cityLocation;
    }

    public String getRegionLocation() {
        return RegionLocation;
    }

    public void setRegionLocation(String regionLocation) {
        RegionLocation = regionLocation;
    }

    public String getDetailsLocation() {
        return DetailsLocation;
    }

    public void setDetailsLocation(String detailsLocation) {
        DetailsLocation = detailsLocation;
    }
}
