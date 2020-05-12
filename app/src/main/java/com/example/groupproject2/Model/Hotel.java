package com.example.groupproject2.Model;

public class Hotel {
    private int hotelId;
    private String hotelName;

    public Hotel(int hotelId, String hotelName) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                '}';
    }
}
