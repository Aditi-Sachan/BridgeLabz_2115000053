import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getPlanName();
}

class Vegetarian implements MealPlan {
    public String getPlanName() { return "Vegetarian Meal"; }
}

class Vegan implements MealPlan {
    public String getPlanName() { return "Vegan Meal"; }
}

class Keto implements MealPlan {
    public String getPlanName() { return "Keto Meal"; }
}

class HighProtein implements MealPlan {
    public String getPlanName() { return "High-Protein Meal"; }
}

class Meal<T extends MealPlan> {
    private T mealType;
    public Meal(T mealType) { this.mealType = mealType; }
    public T getMealType() { return mealType; }
}

class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T meal) {
        return new Meal<>(meal);
    }
}

class MealPlanner {
    public static void main(String[] args) {
        List<Meal<? extends MealPlan>> meals = new ArrayList<>();
        meals.add(MealPlanGenerator.generateMealPlan(new Vegetarian()));
        meals.add(MealPlanGenerator.generateMealPlan(new Vegan()));
        meals.add(MealPlanGenerator.generateMealPlan(new Keto()));
        meals.add(MealPlanGenerator.generateMealPlan(new HighProtein()));
        for (Meal<? extends MealPlan> meal : meals) {
            System.out.println("Meal Plan: " + meal.getMealType().getPlanName());
        }
    }
}
