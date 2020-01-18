package com.gautam.myshop;

public class addresses_model {
    private String fullname;
    private String addresses;
    private String pincode;
    private Boolean selected;


    public addresses_model(String fullname, String addresses, String pincode, Boolean selected) {
        this.fullname = fullname;
        this.addresses = addresses;
        this.pincode = pincode;
        this.selected = selected;
    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }




}
