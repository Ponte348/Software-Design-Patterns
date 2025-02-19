import java.util.Iterator;
import java.util.ListIterator;

public interface Vector<T>{
    public Iterator<T> Iterator();
    public ListIterator<T> listIterator();
    public ListIterator<T> listIterator(int index);
}
