package ms.sample.services.inventoryService.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ProductAddedEvent implements ProductEvent {
	int count;
	String orderId;

	public ProductAddedEvent() {

	}

	public ProductAddedEvent(int count, String orderId) {
		this.count = count;
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
