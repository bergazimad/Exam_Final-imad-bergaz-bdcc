package ma.enset.orderservice.commandeQuery.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.commonapi.events.commandeCreatedEvent;
import ma.enset.commonapi.events.commandeUpdatedEvent;
import ma.enset.commandeservice.commandeQuery.entities.Infraction;
import ma.enset.commandeservice.commandeQuery.repositories.commandeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class orderserviceHandler {
    private commandeRepository commandeRepository;

    @EventHandler
    public void on(commandeCreatedEvent event){
        log.info("**************************");
        log.info("commandeCreatedEvent received");
        commande commande = new commande();
        commande.setId(event.getId());
        commande.setDatecommande(event.getDatecommande());
        commande.setDatelivraison(event.getDatelivraison());
        commande.setadresselivraison(event.getadresselivraison());
        commande.setadresselivraison(event.getadresselivraison());
        commande.setcustomerId(event.getcustomerId());
        commandeRepository.save(commande);
    }



    @EventHandler
    public void on(commandeUpdatedEvent event){
        log.info("**************************");
        log.info("commandeUpdatedEvent received");
        commande commande = commandeRepository.findById(event.getId()).get();
        commande.setDatecommande(event.getDatecommande());
        commande.setDatelivraison(event.getDatelivraison());
        commande.setadresselivraison(event.getadresselivraison());
        commande.setadresselivraison(event.getadresselivraison());
        commande.setcustomerId(event.getcustomerId());
        commandeRepository.save(commande);
    }
}
