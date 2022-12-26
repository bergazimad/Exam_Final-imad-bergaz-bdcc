package ma.enset.orderservice.commandeQuery.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class costumer {
    private String customerId;
    private String nom;
    private String address;
    private String mail;
    private String tel;
}