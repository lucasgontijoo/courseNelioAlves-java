package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Order order = new Order(Instant.now());
		Product product = new Product();
		OrderItem orderItem = new OrderItem();
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		
		System.out.print("Email: ");
		String emailClient = sc.nextLine();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		String birthDateClient = sc.nextLine();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Client client = new Client(nameClient, emailClient, LocalDate.parse(birthDateClient, format));
		order.setClient(client);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.nextLine());
		order.setStatus(orderStatus);
		
		System.out.print("How many items to this order? ");
		int N = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i<N; i++) {
			System.out.println("Enter #" + (i+1) + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			sc.nextLine();
			
			product = new Product(productName, productPrice);
			orderItem = new OrderItem(productQuantity, productPrice, product);
			order.addItem(orderItem);
			
		}
		
		System.out.println();
		System.out.println(order);
		System.out.println(client);
		System.out.println("Order items:");
		for(int i = 0; i<order.getItems().size(); i++) {
			System.out.println(order.getItems().get(i));
		}
		System.out.println("Total price: $" + String.format("%.2f", order.total()));
		sc.close(); 
	}
}
