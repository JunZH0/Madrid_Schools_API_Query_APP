package com.example.proyectoa_pmdm_t2_junzhou.retrofidata;


//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Recurrence {

    @SerializedName("interval")
    @Expose
    private Integer interval;
    @SerializedName("days")
    @Expose
    private String days;
    @SerializedName("frequency")
    @Expose
    private String frequency;

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

}
