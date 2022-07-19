package com.example.mock1.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "media")
public class Media implements Serializable {
    @PrimaryKey
    private int id;
    private String medianame;
    private String transportation;
    private Double price;

    public Media(int id, String medianame, String transportation, Double price) {
        this.id = id;
        this.medianame = medianame;
        this.transportation = transportation;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedianame() {
        return medianame;
    }

    public void setMedianame(String medianame) {
        this.medianame = medianame;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", medianame='" + medianame + '\'' +
                ", transportation='" + transportation + '\'' +
                ", price=" + price +
                '}';
    }
}
