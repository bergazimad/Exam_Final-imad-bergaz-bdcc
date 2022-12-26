package ma.enset.orderservice.commandeCommands.aggregates;


import ma.enset.commonapi.commands.CreateInfractionCommand;
import ma.enset.commonapi.commands.UpdateInfractionCommand;
import ma.enset.commonapi.events.InfractionCreatedEvent;
import ma.enset.commonapi.events.InfractionUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
public class commandeAggregate {
    @AggregateIdentifier
    private String id;
    private Datecommande date;
    private Datelivraison date;
    private string adresselivraison;
    private string statut;

    private String CustomerId;

    public commandeAggregate() {
    }

    @CommandHandler
    public commandeAggregate(CreatecommandeCommand command) {
        AggregateLifecycle.apply(new commandeCreatedEvent(
                command.getId(),
                command.getDatecommande(),
                command.getDatelivraison(),
                command.getadresselivraison(),
                command.getstatut(),
                command.getCustomerId()
        ));
    }

    @EventSourcingHandler
    public void on(CommandeCreatedEvent event) {
        this.id = event.getId();
        this.Datecommande = event.getDatecommande();
        this.Datelivraison = event.getDatelivraison();
        this.adresselivraison = event.getadresselivraison();
        this.statut = event.getstatut();
        this.CustomerId = event.getCustomerId();

    }

    @CommandHandler
    public void handle(UpdateInfractionCommand command) {
        AggregateLifecycle.apply(new InfractionUpdatedEvent(
                command.getId(),
                command.getDatecommande(),
                command.getDatelivraison(),
                command.getadresselivraison(),
                command.getstatut(),
                command.getCustomerId()
        ));
    }

    @EventSourcingHandler
    public void on(InfractionUpdatedEvent event) {
        this.id = event.getId();
        this.Datecommande = event.getDatecommande();
        this.Datelivraison = event.getDatelivraison();
        this.adresselivraison = event.getadresselivraison();
        this.statut = event.getstatut();
        this.CustomerId = event.getCustomerId();
    }
}
