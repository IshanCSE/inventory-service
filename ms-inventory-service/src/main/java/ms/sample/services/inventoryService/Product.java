package ms.sample.services.inventoryService;

import static io.eventuate.EventUtil.events;

import java.util.List;

import io.eventuate.Event;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import ms.sample.services.inventoryService.commands.CreateProductCommand;
import ms.sample.services.inventoryService.commands.InventoryCommand;
import ms.sample.services.inventoryService.model.ProductAddedEvent;
import ms.sample.services.inventoryService.model.ProductCreatedEvent;

public class Product extends ReflectiveMutableCommandProcessingAggregate<Product, InventoryCommand> {
	int count;
	String productName;
	int productValue;

	public void apply(ProductAddedEvent event) {
		this.setCount(count - event.getCount());
	}
	
	public void apply(ProductCreatedEvent event) {
		this.setProductName(event.getProductName());
		this.setCount(event.getCount());
		this.setProductValue(event.getProductValue());
	}

	public List<Event> process(CreateProductCommand cmd) {
		return events(new ProductCreatedEvent(cmd.getProductName(), cmd.getCount(), cmd.getProductValuel()));
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductValue() {
		return productValue;
	}

	public void setProductValue(int productValue) {
		this.productValue = productValue;
	}

}
