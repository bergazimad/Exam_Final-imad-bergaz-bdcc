package coreapi

abstract class BaseEvent<T> (
    open val id: T
);
data class CustomerCreatedEvent(
    override val id : String,
    val payload:CustomerDTO
):BaseCommand<String>(id);


data class CustomerEditedEvent(
        override val id : String,
        val payload:EditCustomerDTO
):BaseCommand<String>(id);

data class VehicleOverSpeedDetectedEvent(
    override val id : String,
    val payload : OverSpeedRequestDTO,
    val contraventionId : String,
) : BaseEvent<String>(id);

data class InfractionCreatedEvent(
    override val id : String,
    val payload : InfractionData,
) : BaseEvent<String>(id);

//======================================//
//========= IMatriculation Center ===== //
//======================================//

data class VehicleCreatedEvent(
    override val id : String,
    val payload:VehicleRequestDTO
):BaseCommand<String>(id);

data class VehicleOwnerUpdatedEvent(
    override val id : String,
    val payload:UpdateVehicleOwnerRequestDTO
):BaseCommand<String>(id);

