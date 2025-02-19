public class SpongeCakeBuilder implements CakeBuilder {
    private Cake cake;
    
    
    public SpongeCakeBuilder() {
        cake = null;
    }

    @Override
    public void createCake() {
        cake = new Cake();
        addCakeLayer();
        setCakeShape(Shape.Square);
        addCreamLayer();
        addTopLayer();
        addMessage("Well done");
        addTopping();
        cake.setNumCakeLayers(2);
    }

    @Override
    public void addCakeLayer() {
        cake.setCakeLayer("Sponge");
    }

    @Override
    public void addCreamLayer() {
        cake.setMidLayerCream(Cream.Red_Berries);
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
