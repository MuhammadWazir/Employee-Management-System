package assignment1summer;
import java.util.Scanner;

public class Company {
	private Employee[] employees;
	private final int MANAGER_BONUS = 2;
	
	//Constructor
	public Company(int size) {
		employees = new Employee[size];
	}
	public void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1.Add employee\r\n"
				+ "2.Delete employee\r\n"
				+ "3.Raise salary\r\n"
				+ "4.List all\r\n"
				+ "5.Exit\r\n"
				+ "----------------------\r\n"
				+ "Enter your choice:\r\n"
				);
		String ans = scan.next();
		switch(ans) {
			case "1":
				addEmployee();
				break;
			case "2":
				deleteEmployee();
				break;
			case "3":
				raiseSalary();
				break;
			case "4":
				listAll();
				break;
			case "5":
				return;
			default:
				System.out.println("Invalid answer.");
		}
		menu();
	}
	public void addEmployee() {
		/*takes input for name, salary, hire day.
		 * Asks whether the employee is a manager. If so, prompts for the name of the secretary
		 * tests if the employee is already present.
		 */
		Scanner scan = new Scanner(System.in);
		Employee new_employee;
		
		System.out.println("Enter the first and last name of the emplyee separated by a comma: ");
		String name = scan.nextLine();
		String[] first_and_last= new String[2];
		if(name.contains(",")) {
			first_and_last = name.split(",");
		}
		else {
			first_and_last[0]= name; first_and_last[1]="..";
		}
		
		System.out.println("Enter the salary of the employee: ");
		Double salary = scan.nextDouble();
		
		System.out.println("Enter the hire day of the employee: ");
		String hire_day = scan.next();
		
		System.out.println("Is the employee a manager? (Y/N) ");
		String ans = scan.next();
		
		if(ans.equalsIgnoreCase("Y")) {
			//If the employee is a manager, prompt for the secretary name, then create the appropriate object
			System.out.println("Enter the name of the secretary: ");
			String secretary = scan.next();
			
			new_employee = new Manager(first_and_last[0], first_and_last[1], hire_day, salary, secretary);
		}
		else {
			//If the employee is not a manager, just create an object of the type "Employee"
			new_employee = new Employee(first_and_last[0], first_and_last[1], hire_day, salary);
		}
		for(int i = 0; i <employees.length; i++) {
			if(employees[i]!=null) {
				//validate if employee already exists
				if(employees[i].areEqual(new_employee)) {
				System.out.println("employee already exists");
				return;
				}
			}
		}
		for(int i = 0; i <employees.length; i++) {
			if(employees[i]==null) {
				employees[i]=new_employee;
				return;
			}
		}
	}
	public void deleteEmployee() {
		/*prompts for name
		 * validates name
		 * deletes employee
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the employee you want to delete: ");
		String name = scan.next();
		String[] first_last = name.split(",");
		
		for(int i =0; i<employees.length;i++) {
			if((employees[i].getFirst_name()).equals(first_last[0])&& (employees[i].getLast_name()).equals(first_last[1])) {
				employees[i]=null;
				if(i!=employees.length-1 && employees[i+1]!=null) {
					for(int j = employees.length-1; j>-1;j--) {
						if(employees[j]!=null) {
							employees[i]= employees[j];
							employees[j]=null;
							
						}
					}
				}
				System.out.println("Employee is deleted.");
				return;
			}
		}
		System.out.println("Employee was not found.");
	}
	public void raiseSalary() {
		/*prompts for the name and the raise percentage.
		 * validates name.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the employee you want to delete: ");
		String name = scan.next();
		String[] first_last = name.split(",");
		
		for(int i =0; i<employees.length;i++) {
			if((employees[i].getFirst_name()).equals(first_last[0])&& (employees[i].getLast_name()).equals(first_last[1])) {
				System.out.println("Enter the raise percentage: ");
				double raise = scan.nextDouble();
				//if the employee is a manager, a manager bonus of 2% will be added to the raise amount automatically
				if(employees[i] instanceof Manager) employees[i].setSalary(employees[i].getSalary()*(1+((raise+MANAGER_BONUS)/100)));
				else employees[i].setSalary(employees[i].getSalary()*(1+((raise)/100)));
				return;
			}
		}
		System.out.println("Employee was not found.");
	}
	public void listAll() {
		//Method to list all employees
		for(int i = 0; i< employees.length; i++) {
			if(employees[i]==null)return;
			if(employees[i] instanceof Manager) System.out.println("M: " + employees[i].toString());
			else System.out.println(employees[i].toString());
		}
	}
	public static void main(String[]args) {
		Company c = new Company(150);
		c.menu();
	}
}
