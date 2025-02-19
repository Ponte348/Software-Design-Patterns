import java.util.ArrayList;

public class Bogosort implements Strategy{
    @Override
    public void sort(ArrayList<Telemovel> telemovelList, String key) {
        boolean sorted = false;
        while (!sorted) {
            for (int i = 0; i < telemovelList.size(); i++) {
                int randomIndex = (int) (Math.random() * telemovelList.size());
                Telemovel temp = telemovelList.get(i);
                telemovelList.set(i, telemovelList.get(randomIndex));
                telemovelList.set(randomIndex, temp);
            }
            sorted = true;
            for (int i = 0; i < telemovelList.size() - 1; i++) {
                if (telemovelList.get(i).compareTo(telemovelList.get(i + 1), key) > 0) {
                    sorted = false;
                    break;
                }
            }
        }
    }
}
