import java.util.ListIterator;

public class VectorListIterator<T> implements ListIterator<T> {
    private VectorGeneric<T> vector;
    private int index;

    public VectorListIterator(VectorGeneric<T> vector, int index) {
        this.vector = vector;
        this.index = index;
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

    @Override
    public boolean hasPrevious() {
        return index > 0;
    }

    @Override
    public T previous() {
        if(hasPrevious()) {
            return vector.getElem(--index);
        }
        else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    @Override
    public int nextIndex() {
        return index;
    }

    @Override
    public int previousIndex() {
        return index - 1;
    }

    @Override
    public void remove() {
        vector.removeElem(vector.getElem(index));
    }

    @Override
    public void add(T e) {
        vector.addElem(e);
    }

    @Override
    public void set(T e) {
        VectorGeneric<T> newVector = new VectorGeneric<T>();
        for(int i = 0; i < vector.totalElem(); i++) {
            if(i == index) {
                newVector.addElem(e);
            }
            else {
                newVector.addElem(vector.getElem(i));
            }
        }
        vector = newVector;
    }
}
