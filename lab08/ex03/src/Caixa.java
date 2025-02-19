import java.util.ArrayList;

public class Caixa implements Produto {
    private final String name;
    private final double weight;
    ArrayList<Produto> content;

    /**
     * Constructs a new Caixa object with the specified name and weight.
     * @param name the name of the box
     * @param weight the weight of the box
     */
    private Caixa(String name, double weight){
        this.name = name;
        this.weight = weight;
        this.content = new ArrayList<>();
    }

    /**
     * Creates a new Caixa object with the specified name and weight.
     * @param name the name of the box
     * @param weight the weight of the box
     * @return the created Caixa object
     */
    public static Caixa createCaixa(String name, double weight){
        return new Caixa(name, weight);
    }

    /**
     * Adds a Leaf object to the content of the box.
     * @param c the Leaf object to be added
     */
    public void add(Produto c){
        this.content.add(c);
    }

    /**
     * Removes a Leaf object from the content of the box.
     * @param c the Leaf object to be removed
     */
    public void remove(Produto c){
        this.content.remove(c);
    }

    /**
     * Returns the weight of the box itself.
     * @return the weight of the box
     */
    public double thisWeight(){
        return this.weight;
    }

    /**
     * Returns the total weight of the box and its contents.
     * @return the total weight of the box and its contents
     */
    public double getWeight(){
        double total = this.weight;
        for(Produto c : this.content){
            total += c.getWeight();
        }
        return total;
    }

    /**
     * Returns a string representation of the box and its contents.
     * @param tab the number of tabs for indentation
     * @return a string representation of the box and its contents
     */
    public String drawString(int tab){
        String str = ("\t").repeat(tab) + this.toString();
        for(Produto c : this.content){
            str += "\n" + c.drawString(tab + 1);
        }

        return str;
    }

    /**
     * Returns a string representation of the box.
     * @return a string representation of the box
     */
    @Override
    public String toString() {
        return "* Caixa \'" + this.name + "\' [ Weight: " + this.thisWeight() + " ; Total: " + this.getWeight() + "]";   
    }

    /**
     * Prints a string representation of the box and its contents.
     */
    public void draw(){
        System.out.println(this.drawString(0));
    }
}
