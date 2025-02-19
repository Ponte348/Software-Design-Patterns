public class Colleague {
    private ChatMediator mediator;
    private String name;

    public Colleague(ChatMediator mediator) {
        this.mediator = mediator;
        // geenrate random name
        this.name = "Colleague " + (int)(Math.random() * 100);
    }

    public void sendMessage() {
        mediator.notify(this);
    }

    public void receiveMessage(Colleague sender) {
        System.out.println(name + " received message from " + sender);
    }

    @Override
    public String toString() {
        return name;
    }
}
