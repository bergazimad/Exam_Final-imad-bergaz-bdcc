package coreapi


import org.axonframework.modelling.command.TargetAggregateIdentifier

//======================================//
//========= Radar Service============= //
//======================================//

abstract class BaseCommand<T>(
    @TargetAggregateIdentifier open val id : T
);
data class CreateNewCustomerCommand(
        override val id : String,
        val payload : CustomerDTO,
) : BaseCommand<String>(id);



data class EditCustomerCommand(
    override val id : String,
    val payload : EditCustomerDTO,
) : BaseCommand<String>(id);

data class NewVehicleOverSpeedDetectionCommand(
        override val id : String,
        val payload : OverSpeedRequestDTO,
) : BaseCommand<String>(id);

data class NewInfractionCommand(
    override val id : String,
    val payload : OverSpeedRequestDTO,
) : BaseCommand<String>(id);


//======================================//
//========= IMatriculation Center ===== //
//======================================//

data class CreateVehicleCommand(
        override val id : String,
        val payload : VehicleRequestDTO,
) : BaseCommand<String>(id);

data class UpdateVehicleOwnerCommand(
        override val id : String,
        val payload : UpdateVehicleOwnerRequestDTO,
) : BaseCommand<String>(id);
