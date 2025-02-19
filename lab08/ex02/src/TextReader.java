import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Paths;

public class TextReader implements TextProcessor{
    private final List<String> text;

    public TextReader(String filename){
        try{
            this.text = Files.readAllLines(Paths.get(filename));
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean hasNext(){
        return !text.isEmpty();
    }

    @Override
    public String next(){
        String s = text.get(0);
        text.remove(0);
        return s;
    }

}
