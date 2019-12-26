package ms.sample.services.inventoryService.commands;

public class UseProductCountCommand implements InventoryCommand{
	private int count;
	private String orderId;

	public UseProductCountCommand(int count, String orderId) {
		super();
		this.count = count;
		this.orderId = orderId;
	}

	public int getCount() {
		return count;
	}

	public String getOrderId() {
		return orderId;
	}	
	
}
