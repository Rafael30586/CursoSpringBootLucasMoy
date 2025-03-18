package academy.atl.customers.entities;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "customers")
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;

}
