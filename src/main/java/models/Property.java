package models;

import java.io.Serializable;

public class Property implements Serializable {
    // To implement Serializable in our User class
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String description;
    private String address;
    private float minPrice;
    private float maxPrice;
    private String status; // sold, rent, buy
    private int ownerId;

    // Empty constructor (is needed as its a Java Bean)
    public Property() {
        this.setId(0);
        this.setTitle("");
        this.setDescription("");
        this.setAddress("");
        this.setMinPrice(0);
        this.setMaxPrice(0);
        this.setStatus("sold");
        this.setOwnerId(0);
    }

    public Property(int id, String title, String description, String address, float minPrice, float maxPrice,
            String status, int ownerId) {
        this.setId(id);
        this.setTitle(title);
        this.setDescription(description);
        this.setAddress(address);
        this.setMinPrice(minPrice);
        this.setMaxPrice(maxPrice);
        this.setStatus(status);
        this.setOwnerId(ownerId);
    }

    /**
     * ==============================
     * 
     * GETTERS AND SETTERS
     * 
     * ==============================
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
