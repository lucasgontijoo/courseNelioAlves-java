package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Locale;

import entities.*;
import entities.enums.WorkerLevel;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		Departament departament = new Departament(sc.nextLine());
		
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Level: ");
		WorkerLevel level = WorkerLevel.valueOf(sc.next());
		
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(name, level, baseSalary, departament);
		
		System.out.print("How many contracts to this worker? ");
		int N = sc.nextInt();
		sc.nextLine();
		
		int contractIndex = 1;
		
		while(N != 0) {
			System.out.println("Enter contract #" + contractIndex + " data:");
			
			System.out.print("Date (DD/MM/YYYY): ");
			String dateStr = sc.nextLine();
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate date = LocalDate.parse(dateStr, format);
			
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			int duration = sc.nextInt();
			sc.nextLine();
			
			HourContract contract = new HourContract(date, valuePerHour, duration);
			worker.addContract(contract);
			
			contractIndex++;
			N--;
		}
		
		System.out.println();
		int month, year;
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		
		String dateStr = sc.next();
		String[] date = dateStr.split("/");
		month = Integer.parseInt(date[0]);
		year = Integer.parseInt(date[1]);
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Departament: " + worker.getDepartament());
		System.out.println("Income for " + String.format("%02d", month) + "/" + year + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}
}