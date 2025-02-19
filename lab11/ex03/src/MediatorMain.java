public class MediatorMain {
    public static void main(String[] args) throws Exception {
        ChatMediator mediator = new ChatMediator();
        Colleague c1 = new Colleague(mediator);
        Colleague c2 = new Colleague(mediator);
        Colleague c3 = new Colleague(mediator);
        Colleague c4 = new Colleague(mediator);

        mediator.addColleague(c1);
        mediator.addColleague(c2);
        mediator.addColleague(c3);
        mediator.addColleague(c4);

        c1.sendMessage();
        c2.sendMessage();
        c3.sendMessage();
        c4.sendMessage();
    }
}
