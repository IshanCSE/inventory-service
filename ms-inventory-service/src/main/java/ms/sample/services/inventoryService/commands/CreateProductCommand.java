package ms.sample.services.inventoryService.commands;

public class CreateProductCommand implements InventoryCommand {
	int count;
	String productName;
	int productValuel;

	public CreateProductCommand(String productName, int count, int productValuel) {
		super();
		this.count = count;
		this.productName = productName;
		this.productValuel = productValuel;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductValuel() {
		return productValuel;
	}

	public void setProductValuel(int productValuel) {
		this.productValuel = productValuel;
	}
}
