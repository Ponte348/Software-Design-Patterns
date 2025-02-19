import java.util.Iterator;
import java.util.ListIterator;

public class Client {
    public static void main(String[] args){
        VectorGeneric<String> vec = new VectorGeneric<String>();
        vec.addElem("um");
        vec.addElem("dois");
        vec.addElem("tres");
        vec.addElem("quatro");

        Vector<String> stringVector = vec;
        Iterator<String> stringIterator;
        ListIterator<String> stringListIterator;

        System.out.println("Teste de Iterator");
        stringIterator = stringVector.Iterator();
        while(stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }

        System.out.println("\nTeste de ListIterator");
        stringListIterator = stringVector.listIterator();
        while(stringListIterator.hasNext()){
            System.out.println(stringListIterator.next());
        }

        System.out.println("\nTeste de ListIterator com index");
        stringListIterator = stringVector.listIterator(1);
        while(stringListIterator.hasNext()){
            System.out.println(stringListIterator.next());
        }

        System.out.println("\nTeste de ListIterator com add e previous");
        stringListIterator = stringVector.listIterator(3);
        stringListIterator.add("cinco");
        stringListIterator.add("seis");
        stringListIterator.previous();
        stringListIterator.previous();
        // Should start in element "dois" because of the previous()
        while(stringListIterator.hasNext()){
            System.out.println(stringListIterator.next());
        }

    }
}
