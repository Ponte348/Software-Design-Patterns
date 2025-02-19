import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TermFilter extends TextDecorator {

    private List<String> wordList;
    public TermFilter(TextProcessor textProcessor){
        super(textProcessor);
        wordList = new ArrayList<>(Arrays.asList(textProcessor.next().split(" ")));
    }

    @Override
    public String next(){
        if (wordList.isEmpty()) {
            wordList = new ArrayList<>(Arrays.asList(textProcessor.next().split(" ")));
        }
        String output = wordList.get(0);
        wordList.remove(0);
        return output;
    }
}
