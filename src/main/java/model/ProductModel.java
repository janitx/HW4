package model;

public class ProductModel {

    private int id;
    private String product;
    private String brand;
    int price;

    public ProductModel() {
    }

    public ProductModel(int id, String product, String brand, int price) {
        this.id = id;
        this.product = product;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}

