class Person{

   String name;

	int age;

	public Person(String name,int age){

	    this.name=name;

		this.age=age;

	}

	public void displayInfo(){

	    System.out.println("Name --> "+name);

		System.out.println("Age --> "+age);

	}

}

class Teacher extends Person{

   String subject;

	public Teacher(String name,int age,String subject){

	    super(name,age);

		this.subject=subject;

	}

	public void displayRole(){

	    System.out.println("Role --> Teacher");

		System.out.println("Subject --> "+subject);

	}

}

class Student extends Person{

   int grade;

	public Student(String name,int age,int grade){

	    super(name,age);

		this.grade=grade;

	}

	public void displayRole(){

	    System.out.println("Role --> Student");

		System.out.println("Grade --> "+grade);

	}

}

class Staff extends Person{

   String department;

   public Staff(String name,int age,String department){

	    super(name,age);

		this.department=department;

	}

	public void displayRole(){

	    System.out.println("Role --> Staff");

		System.out.println("Department --> "+department);

	}

}

public class SchoolSystem{

   public static void main(String[] args){

	    Teacher mathTeacher=new Teacher("Mr. Tripathi",34,"Mathematics");

		Student student1=new Student("Riya",17,10);

		Staff librarian=new Staff("Ms. Kulkarni",30,"Library");

		mathTeacher.displayInfo();

		mathTeacher.displayRole();

		System.out.println();

		student1.displayInfo();

		student1.displayRole();

		System.out.println();

		librarian.displayInfo();

		librarian.displayRole();

	}

}
