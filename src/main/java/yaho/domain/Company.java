package yaho.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Company {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="company_id")
    private Long id;
    private String name;
    private String businessNumber;
    private String telNumber;
    private String email;
//    @OneToOne(mappedBy = "company", fetch = FetchType.LAZY)
//    private Order order;

    public Company() {}

    public Company(String companyName, String businessNumber) {
        this.name = companyName;
        this.businessNumber = businessNumber;
        this.telNumber = "";
        this.email = "";
    }
}
