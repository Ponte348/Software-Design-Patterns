public class Restaurant {
    public static void main(String[] args) throws Exception {
        //create the chefs
        Chef sushiChef = new Sushichef();
        Chef pastaChef = new Pastachef();
        Chef burgerChef = new Burgerchef();
        Chef pizzachef = new Pizzachef();
        Chef dessertChef = new Dessertchef();

        //set the chain of responsability
        sushiChef.setNexChef(pastaChef);
        pastaChef.setNexChef(burgerChef);
        burgerChef.setNexChef(pizzachef);
        pizzachef.setNexChef(dessertChef);

        //create the orders
        Food veggieBurger = new Burger("veggie burger");
        Food carbonara = new Pasta("Pasta Carbonara");
        Food plainPizza = new Pizza("PLAIN pizza, no toppings");
        Food nigiri = new Sushi("sushi nigiri and sashimi");
        Food salad = new Salad("Salad with tuna");
        Food dessert = new Dessert("strawberry ice cream and waffles dessert");

        //cook the orders
        System.out.println("Can i get a " + veggieBurger.order + "?");
        sushiChef.cook(veggieBurger);
        System.out.println();

        System.out.println("Can i get a " + carbonara.order + "?");
        sushiChef.cook(carbonara);
        System.out.println();
        

        System.out.println("Can i get a " + plainPizza.order + "?");
        sushiChef.cook(plainPizza);
        System.out.println();
        

        System.out.println("Can i get a " + nigiri.order + "?");
        sushiChef.cook(nigiri);
        System.out.println();
        

        System.out.println("Can i get a " + salad.order + "?");
        sushiChef.cook(salad);
        System.out.println();
        

        System.out.println("Can i get a " + dessert.order + "?");
        sushiChef.cook(dessert);
        System.out.println();
        

    }
}
