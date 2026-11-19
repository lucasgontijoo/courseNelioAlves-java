package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
	private String name;
	private String email;
	private LocalDate birthDate;
	
	public Client(String name, String email, LocalDate birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		sb.append("Client: ");
		sb.append(name);
		sb.append(" (");
		sb.append(birthDate.format(format));
		sb.append(") - ");
		sb.append(email);
		
		return sb.toString();
	}
}
