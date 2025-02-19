public class ChocolateCakeBuilder implements CakeBuilder {
    private Cake cake;
    
    
    public ChocolateCakeBuilder() {
        cake = null;
    }

    @Override
    public void createCake() {
        cake = new Cake();
        addCakeLayer();
        setCakeShape(Shape.Circle);
        addTopLayer();
        addMessage("Congratulations");
        addTopping();
        cake.setNumCakeLayers(1);
    }

    @Override
    public void addCakeLayer() {
        cake.setCakeLayer("Soft chocolate");
    }

    @Override
    public void addCreamLayer() {
    }

    @Override
    public void addMessage(String message) {
        cake.setMessage(message);
    }

    @Override
    public void addTopLayer() {
        cake.setTopLayerCream(Cream.Whipped_Cream);
    }

    @Override
    public void addTopping() {
        cake.setTopping(Topping.Fruit);
    }

    @Override
    public Cake getCake() {
        return cake;
    }

    @Override
    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }
}
