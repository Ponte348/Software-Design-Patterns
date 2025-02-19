public class Dessertchef extends Chef{
    public void setNexChef(Chef nextChef){
        super.nextChef = nextChef;
    }

    public void cook(Food food){
        if(food.foodType == FoodType.DESSERT){
            System.out.println("DessertChef: Starting to cook " + food.order +". Out in 17 minutes!");
        }else if(nextChef != null){
            System.out.println("DessertChef: I can't cook that!");
            nextChef.cook(food);
        }else{
            System.out.println("We're sorry, but that request can't be satisfied by our service!");
        }
    }
}