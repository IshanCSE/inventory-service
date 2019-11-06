package ms.sample.services.inventoryService.controller;

public class CreateProductRequest {
	private int count;
	private int productValue;
	private String productName;

	public CreateProductRequest() {
		super();
	}
	public CreateProductRequest(int count, int productValue, String productName) {
		super();
		this.count = count;
		this.productValue = productValue;
		this.productName = productName;
	}

	public int getCount() {
		return count;
	}

	public int getProductValue() {
		return productValue;
	}

	public String getProductName() {
		return productName;
	}


}
