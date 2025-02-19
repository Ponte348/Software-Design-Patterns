public class Conserva implements Produto {
    
    private final String name;
    private final double weight;

    /**
     * Constructs a new `Conserva` object with the specified name and weight.
     * 
     * @param name   the name of the conserva
     * @param weight the weight of the conserva
     */
    private Conserva(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Creates a new `Conserva` object with the specified name and weight.
     * 
     * @param name   the name of the conserva
     * @param weight the weight of the conserva
     * @return a new `Conserva` object
     */
    public static Conserva createConserva(String name, double weight) {
        return new Conserva(name, weight);
    }

    /**
     * Prints a string representation of the `Conserva` object.
     */
    public void draw() {
        System.out.println(this.toString());
    }

    /**
     * Returns the weight of the `Conserva` object.
     * 
     * @return the weight of the conserva
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Returns a string representation of the `Conserva` object with the specified indentation level.
     * 
     * @param tab the indentation level
     * @return a string representation of the conserva
     */
    public String drawString(int tab) {
        return ("\t").repeat(tab) + "Conserva: " + "'" + this.name + "' - Weight : " + this.weight;
    }

    /**
     * Returns a string representation of the `Conserva` object.
     * 
     * @return a string representation of the conserva
     */
    public String toString() {
        return "Conserva: " + "'" + this.name + "' - Weight : " + this.weight;
    }
}
