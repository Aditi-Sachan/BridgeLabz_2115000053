import com.fasterxml.jackson.core.JsonProcessingException;  
import com.fasterxml.jackson.databind.ObjectMapper;  
import java.util.List;  

class Car {  
    private String model;  
    private int year;  

    public Car(String model, int year) {  
        this.model = model;  
        this.year = year;  
    }  

    public String getModel() {  
        return model;  
    }  

    public int getYear() {  
        return year;  
    }  
}  

class ConvertToJsonArray {  
    public static void main(String[] args) {  
        List<Car> cars = List.of(new Car("Toyota", 2020), new Car("Honda", 2021));  
        ObjectMapper objectMapper = new ObjectMapper();  
        try {  
            String jsonArray = objectMapper.writeValueAsString(cars);  
            System.out.println(jsonArray);  
        } catch (JsonProcessingException e) {  
            e.printStackTrace();  
        }  
    }  
}  
