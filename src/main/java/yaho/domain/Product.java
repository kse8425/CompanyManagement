package yaho.domain;


import lombok.*;

import javax.persistence.*;

@Getter @Setter @Entity @ToString
@NoArgsConstructor
@AllArgsConstructor @Builder
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long id;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
