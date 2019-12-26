package ms.sample.services.inventoryService;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;

public interface InventoryService {
	EntityWithIdAndVersion<Product> createProduct(String productName, int count, int productValue);
	EntityWithMetadata<Product> getProduct(String orderId);
}
