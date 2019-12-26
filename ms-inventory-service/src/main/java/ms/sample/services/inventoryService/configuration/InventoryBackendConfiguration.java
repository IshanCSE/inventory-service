package ms.sample.services.inventoryService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.eventuate.javaclient.spring.EnableEventHandlers;
import io.eventuate.sync.AggregateRepository;
import io.eventuate.sync.EventuateAggregateStore;
import ms.sample.services.inventoryService.InventoryService;
import ms.sample.services.inventoryService.InventoryServiceImpl;
import ms.sample.services.inventoryService.Product;
import ms.sample.services.inventoryService.commands.InventoryCommand;
import ms.sample.services.inventoryService.eventHandlers.ProductWorkflow;

@Configuration
@EnableEventHandlers
public class InventoryBackendConfiguration {

	@Bean
	public InventoryService inventoryService(AggregateRepository<Product, InventoryCommand> inventoryRepository) {
		return new InventoryServiceImpl(inventoryRepository);
	}

	@Bean
	public AggregateRepository<Product, InventoryCommand> inventoryRepository(EventuateAggregateStore eventStore) {
		return new AggregateRepository<Product, InventoryCommand>(Product.class, eventStore);
	}

	@Bean
	public ProductWorkflow inventoryEventSubscriber() {
		return new ProductWorkflow();
	}

}
