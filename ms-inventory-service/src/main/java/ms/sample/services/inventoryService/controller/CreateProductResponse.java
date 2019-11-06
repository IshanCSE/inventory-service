package ms.sample.services.inventoryService.controller;

public class CreateProductResponse {
	private String orderId;

	public CreateProductResponse(String orderId) {
		super();
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

}
