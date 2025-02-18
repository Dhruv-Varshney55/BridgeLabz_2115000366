interface MealPlan{
    void displayMealInfo();
}

class VegetarianMeal implements MealPlan{
    @Override
    public void displayMealInfo(){
        System.out.println("This is a vegetarian meal plan");
    }
}

class VeganMeal implements MealPlan{
    @Override
    public void displayMealInfo(){
        System.out.println("This is a vegan meal plan");
    }
}

class KetoMeal implements MealPlan{
    @Override
    public void displayMealInfo(){
        System.out.println("This is a keto meal plan");
    }
}

class HighProteinMeal implements MealPlan{
    @Override
    public void displayMealInfo(){
        System.out.println("This is a high protein meal plan");
    }
}

class Meal<T extends MealPlan>{
    private T meal;

    public Meal(T meal){
        this.meal = meal;
    }

    public void generateMealPlan(){
        if(meal != null){
            meal.displayMealInfo();
        }
		else{
            System.out.println("Invalid meal plan selected");
        }
    }
}

class MealPlanApp{
    public static <T extends MealPlan> void generatePersonalizedMeal(T mealPlan){
        Meal<T> meal = new Meal<>(mealPlan);
        meal.generateMealPlan();
    }
}

public class MealPlanGenerator{
    public static void main(String[] args){
        VegetarianMeal veg = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        HighProteinMeal highProtein = new HighProteinMeal();
        System.out.println("Personalized Meal Plan 1:");
        MealPlanApp.generatePersonalizedMeal(veg);
        System.out.println("\nPersonalized Meal Plan 2:");
        MealPlanApp.generatePersonalizedMeal(vegan);
        System.out.println("\nPersonalized Meal Plan 3:");
        MealPlanApp.generatePersonalizedMeal(keto);
        System.out.println("\nPersonalized Meal Plan 4:");
        MealPlanApp.generatePersonalizedMeal(highProtein);
    }
}
