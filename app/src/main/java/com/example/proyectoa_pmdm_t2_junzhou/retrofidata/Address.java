package com.example.proyectoa_pmdm_t2_junzhou.retrofidata;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Address {

    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("district")
    @Expose
    private String district;
    @SerializedName("street-address")
    @Expose
    private String streetAddress;
    @SerializedName("postal-code")
    @Expose
    private String postalCode;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

}