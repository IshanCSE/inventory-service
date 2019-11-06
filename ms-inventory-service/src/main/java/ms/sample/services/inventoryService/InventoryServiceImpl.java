package ms.sample.services.inventoryService;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.sync.AggregateRepository;
import ms.sample.services.inventoryService.commands.CreateProductCommand;
import ms.sample.services.inventoryService.commands.InventoryCommand;
import ms.sample.services.inventoryService.commands.UseProductCountCommand;

public class InventoryServiceImpl implements InventoryService {

	private final AggregateRepository<Product, InventoryCommand> inventoryRepository;

	public InventoryServiceImpl(AggregateRepository<Product, InventoryCommand> inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}
	
	public EntityWithIdAndVersion<Product> createProduct(String productName, int count, int productValue) {
		System.out.println("Create product request received");
		return  inventoryRepository.save(new CreateProductCommand(productName, count, productValue));
	}
	
	public EntityWithIdAndVersion<Product> useProductCount(String productId, int count) {
		EntityWithIdAndVersion<Product> product = inventoryRepository.update(productId, new UseProductCountCommand(count));
		return product;
	}

}
