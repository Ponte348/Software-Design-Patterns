import java.util.Collection;

public class AddCommand<E> extends Command<E>{
    public AddCommand(Collection<E> elements, Collection<E> backup) {
        super(elements, backup);
    }

    public void execute(E element) {
        saveBackup();
        elements.add(element);
    }
}
