package yaho.domain;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private int id;
    private String name;
    private int price;

    public Product() {
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
