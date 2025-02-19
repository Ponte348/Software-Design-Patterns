public class Bebida implements Produto {

    private final String name;
    private final double weight;

    private Bebida(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    /**
     * Creates a new instance of Bebida with the given name and weight.
     * @param name The name of the beverage.
     * @param weight The weight of the beverage.
     * @return The created Bebida object.
     */
    public static Bebida createBebida(String name, double weight){
        return new Bebida(name, weight);
    }

    /**
     * Gets the weight of the beverage.
     * @return The weight of the beverage.
     */
    public double getWeight(){
        return this.weight;
    }

    /**
     * Prints the string representation of the beverage.
     */
    public void draw(){
        System.out.println(this.toString());
    }
    

    /**
     * Returns the string representation of the beverage with indentation.
     * @param tab The number of tabs for indentation.
     * @return The string representation of the beverage.
     */
    public String drawString(int tab){
        return ("\t").repeat(tab) + "Bebida: " + "'" + this.name + "' - Weight : " + this.weight;
    }

    /**
     * Returns the string representation of the beverage.
     * @return The string representation of the beverage.
     */
    public String toString(){
        return "Bebida: " + "'" + this.name + "' - Weight : " + this.weight;
    }
}
