public class Produto extends Observable{
    private static int baseID = 0;
    private int id;
    private String descricao;
    private double basePrice;
    private double price;
    private State state;

    public Produto(String descricao, double basePrice){
        baseID ++;
        this.id = baseID;
        this.basePrice = basePrice;
        this.price = basePrice;
        this.descricao = descricao;
        this.state = State.STOCK;
    }

    public int getID(){
        return this.id;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public double getPrice(){
        return this.price;
    }

    public State getState(){
        return this.state;
    }

    public void setState(State state){
        this.state = state;
    }

    public void bid(Cliente client, double price) {
        System.out.println("Client " + client + " has bid " + price + " on " + descricao);
        if (this.state == State.STOCK) {
            System.out.println("This item is not for auction right now.");
        } else if (this.state == State.SOLD) {
            System.out.println("This item has been sold already.");
        } else if (price <= this.price) {
            System.out.println("Your bid must be higher than the current bid!");
        } else {
            subscribe(client);
            this.price = price;
            notifyObservers();
        }
        System.out.println();
    }

    public void closeBidding() {
        System.out.println("Bidding is closed.");

        if (price == basePrice) {
            state = State.STOCK;
        } else {
            state = State.SOLD;
            notifyObservers();
        }
    }

    public void notifyObservers() {
        for (Observer obs : listOfObservers) {
            obs.update(this.id);
        }
    }
}