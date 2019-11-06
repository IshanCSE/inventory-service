package ms.sample.services.inventoryService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.eventuate.EntityWithIdAndVersion;
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
	public ResponseEntity<CreateProductResponse> createOrder(@RequestBody CreateProductRequest createOrderRequest) {
		EntityWithIdAndVersion<Product> product = inventoryService.createProduct(createOrderRequest.getProductName(),
				createOrderRequest.getCount(), createOrderRequest.getProductValue());
		return new ResponseEntity<CreateProductResponse>(new CreateProductResponse(product.getEntityId()), HttpStatus.OK);
	}
}
