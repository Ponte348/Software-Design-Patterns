public class Pizzachef extends Chef{
    public void setNexChef(Chef nextChef){
        super.nextChef = nextChef;
    }

    public void cook(Food food){
        if(food.foodType == FoodType.PIZZA){
            System.out.println("PizzaChef: Starting to cook " + food.order +". Out in 7 minutes!");
        }else if(nextChef != null){
            System.out.println("PizzaChef: I can't cook that!");
            nextChef.cook(food);
        }else{
            System.out.println("We're sorry, but that request can't be satisfied by our service!");
        }
    }
}
