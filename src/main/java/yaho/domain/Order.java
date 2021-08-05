package yaho.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order {
    private int id;
    private Company company;
    private Product product;
    private int quantity=1;
    private int price;

    public Order(Company company, Product product) {
        this.company = company;
        this.product = product;
        price = quantity * product.getPrice();
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
