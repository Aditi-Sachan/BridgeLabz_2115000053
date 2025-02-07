class Device{

   String deviceId;

	boolean status;

	public Device(String deviceId){

	    this.deviceId=deviceId;

		this.status=false;

	}

	public void turnOn(){

	    this.status=true;

	}

	public void turnOff(){

	    this.status=false;

	}

	public void displayStatus(){

	    System.out.println("Device ID --> "+deviceId);

		System.out.println("Status --> "+(status?"On":"Off"));

	}

}

class Thermostat extends Device{

   double temperatureSetting;

	public Thermostat(String deviceId){

		super(deviceId);

		this.temperatureSetting=16.0;

	}

	public void setTemperature(double temperature){

		this.temperatureSetting=temperature;

	}

	@Override

	public void displayStatus(){

		super.displayStatus();

		System.out.println("Temperature Setting -->"

           +temperatureSetting+"°C");

	}

}

public class SmartHome{

	public static void main(String[] args){

		Thermostat bulb=new Thermostat("bulb-1");

		bulb.displayStatus();

		bulb.turnOn();

		bulb.setTemperature(20.0);

		bulb.displayStatus();

		Device light=new Device("light-2");

		light.turnOn();

		light.displayStatus();

	}

}
