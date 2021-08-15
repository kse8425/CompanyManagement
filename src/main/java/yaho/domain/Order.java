package yaho.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter @Setter @Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private String date;

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity=1;
    private int price;

    public Order() {}

    public Order(Company company, Product product) {
        date = today();
        this.company = company;
        this.product = product;
        price = quantity * product.getPrice();
    }

    private String today() {
        Date todayDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
        String strDate = simpleDateFormat.format(todayDate);
        return strDate;
    }


    /*
      제품 개수가 변하면 총 가격도 변하기 때문에
      별도로 setter 구현
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        price = this.quantity * product.getPrice();
    }
}
