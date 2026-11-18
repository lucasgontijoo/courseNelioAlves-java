package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;
import entities.OrderItem;

public class Order {
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem>items = new ArrayList<>();
	
	public Order(Date moment, OrderStatus status) {
		this.moment = moment;
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
}
