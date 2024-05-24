package com.billing.pdfgenerator.infraestructure.pdf;

public class Product{

    private String name;
    private int quantity;
    private float priceperpeice;

    public Product(String name, int quantity, float priceperpeice) {
        this.name = name;
        this.quantity = quantity;
        this.priceperpeice = priceperpeice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPriceperpeice() {
        return priceperpeice;
    }

    public void setPriceperpeice(float priceperpeice) {
        this.priceperpeice = priceperpeice;
    }
}
