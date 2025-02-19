public class FruitJuice extends Food{
    private FruitName fruitName;

    FruitJuice(){
        super(State.LIQUID, Temperature.COLD);
        // use a random na«umber to decide the fruit name
        int randomFruit = (int) (Math.random() * 6);
        switch (randomFruit){
            case 0:
                fruitName = FruitName.APPLE;
                break;
            case 1:
                fruitName = FruitName.ORANGE;
                break;
            case 2:
                fruitName = FruitName.BANANA;
                break;
            case 3:
                fruitName = FruitName.PEAR;
                break;
            case 4:
                fruitName = FruitName.GRAPE;
                break;
            case 5:
                fruitName = FruitName.WATERMELON;
                break;
        }
    }

    public String toString(){
        return "Fruit Juice: " + fruitName + ", " + super.toString();
    }

}
