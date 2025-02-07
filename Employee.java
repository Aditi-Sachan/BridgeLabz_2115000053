class Employee{

	String name;

	int id;

	double salary;

	public Employee(String name,int id,double salary){

		this.name=name;

		this.id=id;

		this.salary=salary;

	}

	public void displayDetails(){

		System.out.println("Name --> "+name);

		System.out.println("ID --> "+id);

		System.out.println("Salary --> "+salary);

	}

}

class Manager extends Employee{

	int teamSize;

	public Manager(String name,int id,double salary,int teamSize){

		super(name,id,salary);

		this.teamSize=teamSize;

	}

	@Override

	public void displayDetails(){

		super.displayDetails();

		System.out.println("Team Size --> "+teamSize);

	}

}

class Developer extends Employee{

	String programmingLanguage;

	public Developer(String name,int id,double salary,

     String programmingLanguage){

		super(name,id,salary);

		this.programmingLanguage=programmingLanguage;

	}

	@Override

	public void displayDetails(){

		super.displayDetails();

		System.out.println("Programming Language -->"

           +programmingLanguage);

	}

}

class Intern extends Employee{

	String university;

	public Intern(String name,int id,double salary,String university){

		super(name,id,salary);

		this.university=university;

	}

	@Override

	public void displayDetails(){

		super.displayDetails();

		System.out.println("University --> "+university);

	}

}

public class EmployeeManagementSystem{

	public static void main(String[] args){

		Manager manager=new Manager("Rani",101,100000,10);

		Developer developer=new Developer("Pani",102,50000,"Java");

		Intern intern=new Intern("Sani",103,90000,"GLA");

		manager.displayDetails();

		System.out.println();

		developer.displayDetails();

		System.out.println();

		intern.displayDetails();

	}

}

