public class YogurtCakeBuilder implements CakeBuilder {
    private Cake cake;
    
    
    public YogurtCakeBuilder() {
        cake = null;
    }

    @Override
    public void createCake() {
        cake = new Cake();
        addCakeLayer();
        setCakeShape(Shape.Circle);
        addCreamLayer();
        addTopLayer();
        addMessage("The best");
        addTopping();
        cake.setNumCakeLayers(3);
    }

    @Override
    public void addCakeLayer() {
        cake.setCakeLayer("Yogurt");
    }

    @Override
    public void addCreamLayer() {
        cake.setMidLayerCream(Cream.Vanilla);
    }

    @Override
    public void addMessage(String message) {
        cake.setMessage(message);
    }

    @Override
    public void addTopLayer() {
        cake.setTopLayerCream(Cream.Red_Berries);
    }

    @Override
    public void addTopping() {
        cake.setTopping(Topping.Chocolate);
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
