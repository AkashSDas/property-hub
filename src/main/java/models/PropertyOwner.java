package models;

import java.io.Serializable;

public class PropertyOwner implements Serializable {
    // To implement Serializable in our User class
    private static final long serialVersionUID = 1L;

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String ownerImageUrl;

    // Empty constructor (is needed as its a Java Bean)
    public PropertyOwner() {
        this.setId(0);
        this.setFirstName("");
        this.setLastName("");
        this.setPhoneNumber("");
        this.setEmail("");
        this.setOwnerImageUrl("");
    }

    public PropertyOwner(int id, String firstName, String lastName, String phoneNumber, String email, String ownerImageUrl) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
        this.setOwnerImageUrl(ownerImageUrl);
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOwnerImageUrl() {
        return ownerImageUrl;
    }

    public void setOwnerImageUrl(String ownerImageUrl) {
        this.ownerImageUrl = ownerImageUrl;
    }
}
