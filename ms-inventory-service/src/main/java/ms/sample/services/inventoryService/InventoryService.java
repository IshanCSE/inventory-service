package ms.sample.services.inventoryService;

import io.eventuate.EntityWithIdAndVersion;

public interface InventoryService {
	EntityWithIdAndVersion<Product> createProduct(String productName, int count, int productValue);
}
