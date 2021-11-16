package yaho.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Builder
public class Company {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="company_id")
    private Long id;

    private String name;

    private String telNumber;

    private String email;

    private String location;
}
