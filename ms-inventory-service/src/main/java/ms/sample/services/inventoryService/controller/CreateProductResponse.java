package ms.sample.services.inventoryService.controller;

public class CreateProductResponse {
	private String productId;

	public CreateProductResponse(String productId) {
		this.productId = productId;
	}

	public String getProductId() {
		return productId;
	}

}
