package yaho.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Company {
    private int id;
    private String companyName;
    private String businessNumber;
    private String telNumber;
    private String email;

    public Company() {}

    public Company(String companyName, String businessNumber) {
        this.companyName = companyName;
        this.businessNumber = businessNumber;
        this.telNumber = "";
        this.email = "";
    }
}
