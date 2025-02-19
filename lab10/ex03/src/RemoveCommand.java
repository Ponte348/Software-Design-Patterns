import java.util.Collection;

public class RemoveCommand<E> extends Command<E>{
    public RemoveCommand(Collection<E> elements, Collection<E> backup) {
        super(elements, backup);
    }
    public void execute(E element) {
        saveBackup();
        elements.remove(element);
    }
}
