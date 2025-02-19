public class Burgerchef extends Chef{
    public void setNexChef(Chef nextChef){
        super.nextChef = nextChef;
    }

    public void cook(Food food){
        if(food.foodType == FoodType.BURGER){
            System.out.println("BurgerChef: Starting to cook " + food.order +". Out in 19 minutes!");
        }else if(nextChef != null){
            System.out.println("BurgerChef: I can't cook that!");
            nextChef.cook(food);
        }else{
            System.out.println("We're sorry, but that request can't be satisfied by our service!");
        }
    }
}