package entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Instant moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem>items = new ArrayList<>();
	
	public List<OrderItem> getItems() {
		return items;
	}

	public Order(Instant moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}
	
	public Order(Instant moment) {	
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double total = 0.0;
		
		for(int i = 0; i<items.size(); i++) {
			total+= items.get(i).subTotal();
		}
		
		return total;
	}
	
	public String toString() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: ");
		sb.append(format.format(moment) + "\n");
		sb.append("Order statud: ");
		sb.append(status);
		
		return sb.toString();
	}
}
