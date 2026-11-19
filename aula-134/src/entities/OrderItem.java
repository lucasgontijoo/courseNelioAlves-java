package entities;

public class OrderItem {
	private int quantity;
	private double price;
	private Product product;
	
	public OrderItem(int quantity, double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}
	
	public OrderItem() {
		
	}
	
	public double subTotal() {
		return quantity*price;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(product.getName());
		sb.append(", $");
		sb.append(String.format("%.2f", price));
		sb.append(", Quantity: ");
		sb.append(quantity);
		sb.append(", Subtotal: $");
		sb.append(String.format("%.2f", subTotal()));
		
		return sb.toString();
	}
	
	
}
