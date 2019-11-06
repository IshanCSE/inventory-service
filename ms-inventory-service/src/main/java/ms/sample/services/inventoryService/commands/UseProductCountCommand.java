package ms.sample.services.inventoryService.commands;

public class UseProductCountCommand implements InventoryCommand{
	private int count;

	public UseProductCountCommand(int count) {
		super();
		this.count = count;
	}

	public int getCount() {
		return count;
	}	
	
}
