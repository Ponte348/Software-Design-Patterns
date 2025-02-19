public class Cake {
    private Shape shape; 
    private String cakeLayer; 
    private int numCakeLayers; 
    private Cream midLayerCream; 
    private Cream topLayerCream; 
    private Topping topping; 
    private String message;

    public Cake() {
        shape = Shape.Circle;
        numCakeLayers = 0;
        cakeLayer = null;
        midLayerCream = null;
        topLayerCream = null;
        topping = null;
        message = null;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
    public String getShape() {
        return shape.toString();
    }

    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }
    public String getCakeLayer() {
        return cakeLayer;
    }

    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }
    public int getNumCakeLayers() {
        return numCakeLayers;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }
    public String getMidLayerCream() {
        return midLayerCream.toString();
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }
    public String getTopLayerCream() {
        return topLayerCream.toString();
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }
    public String getTopping() {
        return topping.toString();
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        if (cakeLayer.equals("Soft chocolate")) {
            return cakeLayer + " cake with " + numCakeLayers + " layers, topped with " + topLayerCream + " cream and " + topping + ". Message says: \"" + message + "\".\n";
        }
        else if (cakeLayer.equals("Sponge")) {
            return cakeLayer + " cake with " + numCakeLayers + " layers and " + midLayerCream + " cream, topped with " + topLayerCream + " cream and " + topping + ". Message says: \"" + message + "\".\n";
        }
        else if (cakeLayer.equals("Yogurt")) {
            return cakeLayer + " cake with " + numCakeLayers + " layers and " + midLayerCream + " cream, topped with " + topLayerCream + " cream and " + topping + ". Message says: \"" + message + "\".\n";
        }
        else {
            return "Cake not created yet";
        }
    }
}
