public class Pizza extends Food{
    public Pizza(String order){
        super.foodType = FoodType.PIZZA;
        super.order = order;
    }
}