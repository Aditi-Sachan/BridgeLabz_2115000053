class Vehicle{

   int maxSpeed;

	String fuelType;

	public Vehicle(int maxSpeed,String fuelType){

	    this.maxSpeed=maxSpeed;

		this.fuelType=fuelType;

	}

	public void displayInfo(){

	    System.out.println("Max Speed --> "+maxSpeed);

	    System.out.println("Fuel Type --> "+fuelType);

	}

}

class Car extends Vehicle{

   int seatCapacity;

	public Car(int maxSpeed,String fuelType,int seatCapacity){

	    super(maxSpeed,fuelType);

		this.seatCapacity=seatCapacity;

	}

	@Override

	public void displayInfo(){

	    super.displayInfo();

		System.out.println("Seat Capacity --> "+seatCapacity);

	}

}

class Truck extends Vehicle{

   double goods;

	public Truck(int maxSpeed,String fuelType,double goods){

	    super(maxSpeed,fuelType);

	    this.goods=goods;

	}

	@Override

	public void displayInfo(){

	    super.displayInfo();

		System.out.println("Goods --> "+goods);

	}

}

class Motorcycle extends Vehicle{

   boolean hasSidecar;

	public Motorcycle(int maxSpeed,String fuelType,boolean hasSidecar){

	    super(maxSpeed,fuelType);

		this.hasSidecar=hasSidecar;

	}

	@Override

	public void displayInfo(){

	    super.displayInfo();

		System.out.println("Has Sidecar --> "+hasSidecar);

	}

}

public class TransportSystem{

   public static void main(String[] args){

       Vehicle[] vehicles=new Vehicle[3];

		vehicles[0]=new Car(180,"Petrol",5);

		vehicles[1]=new Truck(140,"Diesel",1000.0);

		vehicles[2]=new Motorcycle(190,"Petrol",false);

		for(Vehicle vehicle:vehicles){

		    vehicle.displayInfo();

		    System.out.println();

		}

	}

}
