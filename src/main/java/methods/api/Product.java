package methods.api;

import java.util.Date;

public class Product {
    private double price;
    private String name;
    private long quantity;
    private Date expirationDate;
    private Address address;

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public long getQuantity() {
        return quantity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
