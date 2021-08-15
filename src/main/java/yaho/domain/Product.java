package yaho.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long id;
    private String name;
    private int price;
//    @OneToOne(mappedBy = "product", fetch = FetchType.LAZY)
//    private Order order;

    public Product() {}

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
