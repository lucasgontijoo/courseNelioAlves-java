package entities;

import java.time.LocalDate;

public class HourContract {
	private LocalDate date;
	private Double valuePerHour;
	private Integer hours;
	
	public HourContract(LocalDate date, Double valuePerHour, Integer hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}
	
	public Double totalValue() {
		return valuePerHour*hours;
	}
	
	public int getDateYear() {
		return date.getYear();
	}
	
	public int getDateMonth() {
		return date.getMonthValue();
	}
}
