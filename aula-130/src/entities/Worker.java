package entities;
import entities.enums.WorkerLevel;
import java.util.ArrayList;
import java.util.List;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private List<HourContract> contracts = new ArrayList();
	private Departament departament;
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}
	
	public Worker() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public void setDepartament(Departament departament) {
		this.departament = departament;
	}
	
	public String getDepartament() {
		return departament.getNameDepartament();
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(Integer year, Integer month) {
		Double income = baseSalary;
		
		for(int i = 0; i<contracts.size(); i++) {
			if(contracts.get(i).getDateYear() == year && contracts.get(i).getDateMonth() == month) {
				income += contracts.get(i).totalValue();
			}
		}
		
		return income;
	}
}
