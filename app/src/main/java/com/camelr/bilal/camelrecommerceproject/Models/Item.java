package com.camelr.bilal.camelrecommerceproject.Models;

public class Item {

    private String imageFile;
    private String title;
    private String description;
    private int price;
    private int quantity;
    private String exchangePolicy;
    private String returnPolicy;
    private String domesticChrg;
    private String intlChrg;
    private String sku;

    public Item() {
    }

    public Item(String imageFile, String title, String description, int price, int quantity,
                String sku, String exchangePolicy, String returnPolicy, String domesticChrg, String intlChrg) {

        this.imageFile = imageFile;
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.sku = sku;
        this.exchangePolicy = exchangePolicy;
        this.returnPolicy = returnPolicy;
        this.domesticChrg = domesticChrg;
        this.intlChrg = intlChrg;

    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku (String sku) {
        this.sku = sku;
    }

    public String getExchangePolicy() {
        return exchangePolicy;
    }

    public void setExchangePolicy(String exchangePolicy) {
        this.exchangePolicy = exchangePolicy;
    }

    public String getReturnPolicy() {
        return returnPolicy;
    }

    public void setReturnPolicy(String returnPolicy) {
        this.returnPolicy = returnPolicy;
    }

    public String getDomesticChrg() {
        return domesticChrg;
    }

    public void setDomesticChrg(String domesticChrg) {
        this.domesticChrg = domesticChrg;
    }

    public String getIntlChrg() {
        return intlChrg;
    }

    public void setIntlChrg(String intlChrg) {
        this.intlChrg = intlChrg;
    }

}
