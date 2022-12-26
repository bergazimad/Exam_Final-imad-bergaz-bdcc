package ma.enset.orderservice.commandeQuery.controllers;
import lombok.AllArgsConstructor;
import ma.enset.commonapi.query.GetAllInfractionsQuery;
import ma.enset.commonapi.query.GetInfractionById;
import ma.enset.infractionservice.infractionQuery.entities.Infraction;
import ma.enset.infractionservice.infractionQuery.repositories.InfractionRepository;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande/queries")
@AllArgsConstructor
@CrossOrigin("*")
public class InfractionQueryController {
    private QueryGateway queryGateway;
    private commandeRepository commandeRepository;

    @GetMapping("/getAllcommandes")
    public List<commande> getAllcommandes(){
        return queryGateway.query(new GetAllcommandessQuery(),
                ResponseTypes.multipleInstancesOf(commande.class)).join();
    }

    @QueryHandler
    public List<Infraction> on(GetAllcommandesQuery query){
        return commandeRepository.findAll();
    }

    @GetMapping("/getcommande/{id}")
    public commande getcommande(@PathVariable String id){
        return queryGateway.query(new GetcommandeById(id),
                ResponseTypes.instanceOf(commande.class)).join();
    }

    @QueryHandler
    public commande on(GetcommandeById query){
        return commandeRepository.findById(query
                .getId()).get();
    }
}
