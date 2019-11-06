package ms.sample.services.inventoryService.model;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "net.ishanshah.eventstore.examples.customersandorders.inventoryservice.backend.Product")
public interface ProductEvent extends Event {

}
