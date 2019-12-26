package ms.sample.services.inventoryService.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ProductCreatedEvent implements ProductEvent {
	String productName;
	int count;
	int productValue;

	public ProductCreatedEvent() {
		
	}
	
	public ProductCreatedEvent(String productName, int count, int productValue) {
		super();
		this.productName = productName;
		this.count = count;
		this.productValue = productValue;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getProductValue() {
		return productValue;
	}

	public void setProductValue(int productValue) {
		this.productValue = productValue;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
