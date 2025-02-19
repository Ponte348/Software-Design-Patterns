import java.util.Collection;

public abstract class Command<E> {
    protected Collection<E> elements;
    protected Collection<E> backup;

    public Command(Collection<E> elements, Collection<E> backup) {
        this.elements = elements;
        this.backup = backup;

    }
    public void saveBackup() {
        backup.clear();
        backup.addAll(elements);
        
    }
    public void undo() {
        elements.clear();
        elements.addAll(backup);
    }

    public abstract void execute(E element);
}
