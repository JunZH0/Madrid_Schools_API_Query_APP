package com.example.proyectoa_pmdm_t2_junzhou.retrofidata;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class DatosCentro {

    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("dtend")
    @Expose
    private String dtend;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("event-location")
    @Expose
    private String eventLocation;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("relation")
    @Expose
    private String relation;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("organization")
    @Expose
    private Organization organization;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("dtstart")
    @Expose
    private String dtstart;
    @SerializedName("references")
    @Expose
    private String references;
    @SerializedName("recurrence")
    @Expose
    private Recurrence recurrence;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("excluded-days")
    @Expose
    private String excludedDays;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDtend() {
        return dtend;
    }

    public void setDtend(String dtend) {
        this.dtend = dtend;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDtstart() {
        return dtstart;
    }

    public void setDtstart(String dtstart) {
        this.dtstart = dtstart;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public Recurrence getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(Recurrence recurrence) {
        this.recurrence = recurrence;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExcludedDays() {
        return excludedDays;
    }

    public void setExcludedDays(String excludedDays) {
        this.excludedDays = excludedDays;
    }

}