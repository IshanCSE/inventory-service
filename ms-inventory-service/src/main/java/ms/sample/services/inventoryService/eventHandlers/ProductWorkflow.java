package ms.sample.services.inventoryService.eventHandlers;

import java.util.concurrent.CompletableFuture;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EventHandlerContext;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import ms.sample.services.inventoryService.Product;
import ms.sample.services.inventoryService.commands.UseProductCountCommand;
import ms.sample.services.orderService.model.OrderCreatedEvent;
import ms.sample.services.orderService.model.OrderUpdatedEvent;

@EventSubscriber(id = "productWorkflow")
public class ProductWorkflow {
	@EventHandlerMethod
	public CompletableFuture<EntityWithIdAndVersion<Product>> handleCreateOrder(
			EventHandlerContext<OrderCreatedEvent> ctx) {
		System.out.println("In Handle Create Order ..............");
		System.out.println("Event received for product ..... " + ctx.getEvent().getOrderItems().get(0).getProductId());
		String productId = ctx.getEvent().getOrderItems().get(0).getProductId();

		return ctx.update(Product.class, productId,
				new UseProductCountCommand(ctx.getEvent().getOrderItems().get(0).getCount(),ctx.getEntityId()));
	}
	
	@EventHandlerMethod
	public CompletableFuture<EntityWithIdAndVersion<Product>> handleUpdateOrder(
			EventHandlerContext<OrderUpdatedEvent> ctx) {
		System.out.println("In Handle Update Order ..............");
		System.out.println("Event received for product ..... " + ctx.getEvent().getOrderItems().get(0).getProductId());
		String productId = ctx.getEvent().getOrderItems().get(0).getProductId();

		return ctx.update(Product.class, productId,
				new UseProductCountCommand(ctx.getEvent().getOrderItems().get(0).getCount(),ctx.getEntityId()));
	}
}
