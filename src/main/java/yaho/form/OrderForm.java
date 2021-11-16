package yaho.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class OrderForm {
    private String date;
    private String companyName;
    private String productName;
    private int quantity;
}
