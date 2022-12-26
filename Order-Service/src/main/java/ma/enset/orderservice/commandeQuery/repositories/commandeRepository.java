package ma.enset.orderservice.commandeQuery.repositories;


import ma.enset.orderservice.orderQuery.entities.commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface commandeRepository extends JpaRepository<commande,String> {

}
