package ms.sample.services.inventoryService;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
import io.eventuate.sync.AggregateRepository;
import ms.sample.services.inventoryService.commands.CreateProductCommand;
import ms.sample.services.inventoryService.commands.InventoryCommand;

public class InventoryServiceImpl implements InventoryService {

	private final AggregateRepository<Product, InventoryCommand> inventoryRepository;

	public InventoryServiceImpl(AggregateRepository<Product, InventoryCommand> inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}
	
	public EntityWithIdAndVersion<Product> createProduct(String productName, int count, int productValue) {
		System.out.println("Create product request received");
		return  inventoryRepository.save(new CreateProductCommand(productName, count, productValue));
	}
	
	@Override
	public EntityWithMetadata<Product> getProduct(String productId) {
		System.out.println("Get detail request");
		return inventoryRepository.find(productId);
	}


}
