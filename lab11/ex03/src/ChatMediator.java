import java.util.ArrayList;
import java.util.List;

public class ChatMediator implements Mediator{
    private List<Colleague> colleagues = new ArrayList<Colleague>();

    public void notify(Colleague sender) {
        System.out.println("\n" + sender + " sends message:");
        for (Colleague colleague : colleagues) {
            if (colleague != sender) {
                colleague.receiveMessage(sender);
            }
        }
    }

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }
}
