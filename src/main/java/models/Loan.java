package models;

import java.io.Serializable;

public class Loan implements Serializable {
    // To implement Serializable in our User class
    private static final long serialVersionUID = 1L;

    private int id;
    private String bankName;
    private String bankLogoImageUrl;
    private float minLoanAmount;
    private float maxLoanAmount;
    private String description;

    // Empty constructor (is needed as its a Java Bean)
    public Loan() {
        this.setId(0);
        this.setBankName("");
        this.setBankLogoImageUrl("");
        this.setMinLoanAmount(0);
        this.setMaxLoanAmount(0);
        this.setDescription("");
    }

    public Loan(int id, String bankName, String bankLogoImageUrl, float minLoanAmount, float maxLoanAmount,
            String description) {
        this.setId(id);
        this.setBankName(bankName);
        this.setBankLogoImageUrl(bankLogoImageUrl);
        this.setMinLoanAmount(minLoanAmount);
        this.setMaxLoanAmount(maxLoanAmount);
        this.setDescription(description);
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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankLogoImageUrl() {
        return bankLogoImageUrl;
    }

    public void setBankLogoImageUrl(String bankLogoImageUrl) {
        this.bankLogoImageUrl = bankLogoImageUrl;
    }

    public float getMinLoanAmount() {
        return minLoanAmount;
    }

    public void setMinLoanAmount(float minLoanAmount) {
        this.minLoanAmount = minLoanAmount;
    }

    public float getMaxLoanAmount() {
        return maxLoanAmount;
    }

    public void setMaxLoanAmount(float maxLoanAmount) {
        this.maxLoanAmount = maxLoanAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
