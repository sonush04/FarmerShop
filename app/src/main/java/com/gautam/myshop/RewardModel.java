package com.gautam.myshop;

public class RewardModel {
    private String title;
    private String expiryDate;
    private String cooupenBody;

    public RewardModel(String title, String expiryDate, String cooupenBody) {
        this.title = title;
        this.expiryDate = expiryDate;
        this.cooupenBody = cooupenBody;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCooupenBody() {
        return cooupenBody;
    }

    public void setCooupenBody(String cooupenBody) {
        this.cooupenBody = cooupenBody;
    }

}
