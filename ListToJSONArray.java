import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public JSONObject toJSON() {
        JSONObject carJson = new JSONObject();
        carJson.put("make", make);
        carJson.put("model", model);
        carJson.put("year", year);
        return carJson;
    }
}

class ListToJSONArray {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Corolla", 2022));
        cars.add(new Car("Honda", "Civic", 2023));
        
        JSONArray jsonArray = new JSONArray();
        for (Car car : cars) {
            jsonArray.put(car.toJSON());
        }
        
        System.out.println(jsonArray.toString(4));
    }
}
