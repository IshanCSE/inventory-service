package ms.sample.services.inventoryService.eventHandlers;

import java.util.concurrent.CompletableFuture;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EventHandlerContext;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import ms.sample.services.inventoryService.Product;
import ms.sample.services.inventoryService.commands.UseProductCountCommand;
import ms.sample.services.inventoryService.model.ProductAddedEvent;

@EventSubscriber(id = "productWorkflow")
public class InventoryEventHandler {
	@EventHandlerMethod
	public CompletableFuture<EntityWithIdAndVersion<Product>> creditLimitReserved(
			EventHandlerContext<ProductAddedEvent> ctx) {
		System.out.println("Event received for product ..... " + ctx.getEvent().getProductId());
		String productId = ctx.getEvent().getProductId();

		return ctx.update(Product.class, productId, new UseProductCountCommand(ctx.getEvent().getCount()));
	}
}
