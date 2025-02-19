import java.util.ArrayList;

public class Quicksort implements Strategy{
    @Override
    public void sort(ArrayList<Telemovel> telemovelList, String key) {
        quicksort(telemovelList, 0, telemovelList.size() - 1, key);
    }

    private void quicksort(ArrayList<Telemovel> telemovelList, int low, int high, String key) {
        if (low < high) {
            int pi = partition(telemovelList, low, high, key);
            quicksort(telemovelList, low, pi - 1, key);
            quicksort(telemovelList, pi + 1, high, key);
        }
    }

    private int partition(ArrayList<Telemovel> telemovelList, int low, int high, String key) {
        Telemovel pivot = telemovelList.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (telemovelList.get(j).compareTo(pivot, key) < 0) {
                i++;
                Telemovel temp = telemovelList.get(i);
                telemovelList.set(i, telemovelList.get(j));
                telemovelList.set(j, temp);
            }
        }
        Telemovel temp = telemovelList.get(i + 1);
        telemovelList.set(i + 1, telemovelList.get(high));
        telemovelList.set(high, temp);
        return i + 1;
    }    
}
