package ms.sample.services.inventoryService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
import ms.sample.services.inventoryService.InventoryService;
import ms.sample.services.inventoryService.Product;

@RestController
public class ProductController {
	private InventoryService inventoryService;

	@Autowired
	public ProductController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest createOrderRequest) {
		EntityWithIdAndVersion<Product> product = inventoryService.createProduct(createOrderRequest.getProductName(),
				createOrderRequest.getCount(), createOrderRequest.getProductValue());
		return new ResponseEntity<CreateProductResponse>(new CreateProductResponse(product.getEntityId()),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	public ResponseEntity<GetProductInfoResponse> fetchProduct(@PathVariable("productId") String productId) {
		EntityWithMetadata<Product> product = inventoryService.getProduct(productId);
		return new ResponseEntity<GetProductInfoResponse>(new GetProductInfoResponse(product.getEntity().getCount(),
				product.getEntity().getProductValue(), product.getEntity().getProductName()), HttpStatus.OK);
	}

}
