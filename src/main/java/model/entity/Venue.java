package model.entity;

import java.io.Serializable;

public class Venue extends Entity implements Serializable {
    private int venueID;
    private String city;
    private String street;
    private String house;
    private String room;

    public Venue(Builder builder) {
        this.venueID = builder.venueID;
        this.city = builder.city;
        this.street = builder.street;
        this.house = builder.house;
        this.room = builder.room;
    }

    public int getVenueID() {
        return venueID;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getRoom() {
        return room;
    }

    public void setVenueID(int venueID) {
        this.venueID = venueID;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public static class Builder {
        private int venueID;
        private String city;
        private String street;
        private String house;
        private String room;

        public Builder setVenueID(int venueID) {
            this.venueID = venueID;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setHouse(String house) {
            this.house = house;
            return this;
        }

        public Builder setRoom(String room) {
            this.room = room;
            return this;
        }

        public Venue build() {
            return new Venue(this);
        }
    }
}
