package ma.enset.orderservice.commandeQuery.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class commande {
    @Id
    private String id;
    private Datecommande date;
    private Datelivraison date;
    private string adresselivraison;
    private string statut;
    @Transient
    private costumer costumer;


}
