import java.util.Collection;
import java.util.ArrayList;

public class CollectionsMain {
    public static void main(String[] args){
        Collection<Integer> elements = new ArrayList<Integer>();
        Collection<Integer> backup = new ArrayList<Integer>();
        Command<Integer> addCommand = new AddCommand<Integer>(elements, backup);
        Command<Integer> removeCommand = new RemoveCommand<Integer>(elements, backup);

        for (int i = 0; i < 10; i++) {
            addCommand.execute((int)(Math.random() * 20));
        }
        System.out.println(elements);
        addCommand.undo();
        System.out.println(elements);

        addCommand.execute(50);
        System.out.println(elements);
        removeCommand.execute(50);
        System.out.println(elements);
    }
}
