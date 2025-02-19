public class Doce implements Produto {
    
    private final String name;
    private final double weight;

    private Doce(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    /**
     * Creates a new instance of Doce with the specified name and weight.
     * @param name The name of the sweet.
     * @param weight The weight of the sweet.
     * @return A new instance of Doce.
     */
    public static Doce createDoce(String name, double weight){
        return new Doce(name, weight);
    }

    /**
     * Gets the weight of the sweet.
     * @return The weight of the sweet.
     */
    public double getWeight(){
        return this.weight;
    }

    /**
     * Prints the string representation of the sweet.
     */
    public void draw(){
        System.out.println(this.toString());
    }

    /**
     * Returns the string representation of the sweet with indentation.
     * @param tab The number of tabs for indentation.
     * @return The string representation of the sweet with indentation.
     */
    public String drawString(int tab){
        return ("\t").repeat(tab) + "Doce: " + "'" + this.name + "' - Weight : " + this.weight;
    }

    /**
     * Returns the string representation of the sweet.
     * @return The string representation of the sweet.
     */
    public String toString(){
        return "Doce: " + "'" + this.name + "' - Weight : " + this.weight;
    }
}
