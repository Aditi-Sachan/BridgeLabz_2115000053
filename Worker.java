interface Worker{

   void performDuties();

}

class Person{

   String name;

	int id;

	public Person(String name,int id){

	    this.name=name;

		this.id=id;

	}

	public void displayInfo(){

	    System.out.println("Name --> "+name);

		System.out.println("ID --> "+id);

	}

}

class Chef extends Person implements Worker{

   String specialization;

   public Chef(String name,int id,String specialization){

	    super(name,id);

		this.specialization=specialization;

	}

   @Override

	public void performDuties(){

	    System.out.println(name+" is cooking "+specialization+" dishes");

	}

   public void displayChefInfo(){

	    System.out.println("Specialization --> "+specialization);

	}

}

class Waiter extends Person implements Worker{

   int tablesAssigned;

	public Waiter(String name,int id,int tablesAssigned){

       super(name,id);

		this.tablesAssigned=tablesAssigned;

	}

	@Override

	public void performDuties(){

	    System.out.println(name+" is serving "+tablesAssigned+" tables");

	}

	public void displayWaiterInfo(){

	    System.out.println("Tables Assigned --> "+tablesAssigned);

	}

}

public class RestaurantSystem{

   public static void main(String[] args){

       Chef headChef=new Chef("Gordon Ramsay",1,"French Cuisine");

		Waiter waiter1=new Waiter("Ketan",2,5);

		headChef.displayInfo();

		headChef.displayChefInfo();

		headChef.performDuties();

		System.out.println();

		waiter1.displayInfo();

		waiter1.displayWaiterInfo();

	    waiter1.performDuties();

	}

}
