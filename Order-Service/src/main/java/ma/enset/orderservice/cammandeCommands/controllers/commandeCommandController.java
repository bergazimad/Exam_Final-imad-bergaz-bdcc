package ma.enset.orderservice.commandeCommands.controllers;


import lombok.AllArgsConstructor;
import ma.enset.commonapi.commands.CreateInfractionCommand;
import ma.enset.commonapi.commands.UpdateInfractionCommand;
import ma.enset.commonapi.dtos.CreateInfractionRequestDTO;
import ma.enset.commonapi.dtos.UpdateInfractionRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/commande/commands")
@AllArgsConstructor
@CrossOrigin("*")
public class commandeCommandController {
    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createcommande(@RequestBody CreatecommandeRequestDTO createcommandeRequestDTO) {
        return commandGateway.send(new CreatecommandeCommand(
                UUID.randomUUID().toString(),
                createInfractionRequestDTO.getDatecommande(),
                createInfractionRequestDTO.getDatelivraison(),
                createInfractionRequestDTO.getadresselivraison(),
                createInfractionRequestDTO.getstatut(),
                createInfractionRequestDTO.getCustomerId()

        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updatecommande(@RequestBody UpdateInfractionRequestDTO updatecommandeRequestDTO) {
        return commandGateway.send(new UpdateInfractionCommand(
                updateInfractionRequestDTO.getId(),
                updateInfractionRequestDTO.getDatecommande(),
                updateInfractionRequestDTO.getDatelivraison(),
                updateInfractionRequestDTO.getadresselivraison(),
                updateInfractionRequestDTO.getstatut(),
                updateInfractionRequestDTO.getCustomerId()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        ResponseEntity<String> entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }

    @GetMapping("/eventStore/{id}")
    public Stream getEventStore(@PathVariable String id) {
        return eventStore.readEvents(id).asStream();
    }
}
