package assignment1summer;

public class Manager extends Employee{
	//A manager has a secretary as an additional instance field
	private String secretary;
	
	public Manager(String first, String last, String h, Double s, String secretary) {
		super(first, last, h, s); this.secretary = secretary;
	}
	public String toString(){
		return ("name: "+first_name+" "+last_name+ "\nHire day: "+ hire_day+ "\nSalary: "+ salary
				+ "\nSecretary: "+ secretary);
	}
}
