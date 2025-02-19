import java.util.ArrayList;

public class Bubblesort implements Strategy{
    @Override
    public void sort(ArrayList<Telemovel> telemovelList, String key) {
        for (int i = 0; i < telemovelList.size(); i++) {
            for (int j = 0; j < telemovelList.size() - 1; j++) {
                if (telemovelList.get(j).compareTo(telemovelList.get(j + 1), key) > 0) {
                    Telemovel temp = telemovelList.get(j);
                    telemovelList.set(j, telemovelList.get(j + 1));
                    telemovelList.set(j + 1, temp);
                }
            }
        }
    }
}
