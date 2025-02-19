import java.util.Iterator;

public class VectorIterator<T> implements Iterator<T> {
    public VectorGeneric<T> vector;
    public int index;

    public VectorIterator(VectorGeneric<T> vector) {
        this.vector = vector;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < vector.totalElem();
    }

    @Override
    public T next() {
        if(hasNext()) {
            return vector.getElem(index++);
        }
        else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
}
