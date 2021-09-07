package yaho.web;

import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter @Setter
public class OrderForm {
    private String companyName;
    private String productName;
    private int quantity =1;
}
