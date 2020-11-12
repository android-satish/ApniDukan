package com.developer.satish.apnidukan.Models;

public class RegistrationModel {

    private  int id;
    private  String shopname;
    private  String shopaddress;
    private  String shopphone;
    private  String ownername;
    private  String owneraddress;
    private  String ownermobile;
    private  String shoppin;

    public RegistrationModel(String shopname, String shopaddress, String shopphone, String ownername, String owneraddress, String ownermobile, String shoppin)

    {
        this.shopname = shopname;
        this.shopaddress = shopaddress;
        this.shopphone = shopphone;
        this.ownername = ownername;
        this.owneraddress = owneraddress;
        this.ownermobile = ownermobile;
        this.shoppin = shoppin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getShopaddress() {
        return shopaddress;
    }

    public void setShopaddress(String shopaddress) {
        this.shopaddress = shopaddress;
    }

    public String getShopphone() {
        return shopphone;
    }

    public void setShopphone(String shopphone) {
        this.shopphone = shopphone;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getOwneraddress() {
        return owneraddress;
    }

    public void setOwneraddress(String owneraddress) {
        this.owneraddress = owneraddress;
    }

    public String getOwnermobile() {
        return ownermobile;
    }

    public void setOwnermobile(String ownermobile) {
        this.ownermobile = ownermobile;
    }

    public String getShoppin() {
        return shoppin;
    }

    public void setShoppin(String shoppin) {
        this.shoppin = shoppin;
    }
}
