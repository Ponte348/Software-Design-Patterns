import java.util.ArrayList;

public class Revista {
    private ArrayList<Telemovel> telemovelList = new ArrayList<Telemovel>();
    private Strategy strategy;

    public Revista() {
    }

    public void addTelemovel(Telemovel telemovel) {
        telemovelList.add(telemovel);
    }

    public void printTelemovelList() {
        for (Telemovel telemovel : telemovelList) {
            System.out.println(telemovel);
            System.out.println();
        }
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void sort(String key) {
        strategy.sort(telemovelList, key);
    }
}
