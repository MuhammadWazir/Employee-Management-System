package assignment1summer;

public class Employee {
	protected String first_name, last_name, hire_day;
	protected double salary;
	public String getFirst_name() {
		return first_name;
	}
	
	//Constructor
	public Employee(String first, String last, String hire, double s) {
		first_name = first; last_name = last; hire_day= hire; salary = s;
	}
	
	//Accessors
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getHire_day() {
		return hire_day;
	}
	public void setHire_day(String hire_day) {
		this.hire_day = hire_day;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public boolean areEqual(Employee e) {
		//2 employees are equal if they have the same first name and last name
		return (getFirst_name()==e.getFirst_name() && getLast_name()==e.getLast_name());
	}
	public String toString() {
		return ("name: "+first_name+" "+last_name+ "\nHire day: "+ hire_day+ "\nSalary: "+ salary);
	}
}
