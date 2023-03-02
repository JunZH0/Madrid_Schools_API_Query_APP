package com.example.proyectoa_pmdm_t2_junzhou.retrofidata;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Organization {

    @SerializedName("accesibility")
    @Expose
    private String accesibility;
    @SerializedName("services")
    @Expose
    private String services;
    @SerializedName("schedule")
    @Expose
    private String schedule;
    @SerializedName("organization-name")
    @Expose
    private String organizationName;
    @SerializedName("organization-desc")
    @Expose
    private String organizationDesc;

    public String getAccesibility() {
        return accesibility;
    }

    public void setAccesibility(String accesibility) {
        this.accesibility = accesibility;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDesc() {
        return organizationDesc;
    }

    public void setOrganizationDesc(String organizationDesc) {
        this.organizationDesc = organizationDesc;
    }

}