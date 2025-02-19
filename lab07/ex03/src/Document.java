import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Document {
    private static final int charNum = 500;
    String title;
    String text[];

    private Document(String title, String[] text){
        this.title = title;
        this.text = text;
    }

    public static Document creaDocument(String title, String[] text){
        return new Document(title, text);
    }

    public static Document createDocument(String filename){
        try{

            String data = new String(Files.readAllBytes(Paths.get(filename)));

            int numOfPages = (int) Math.ceil((double) data.length()/charNum);
            String[] pages = new String[numOfPages];
            
            for(int i=0; i<numOfPages; i++){
                int indexStart = i*charNum;
                int indexEnd = Math.min(indexStart+charNum, data.length());
                pages[i] = data.substring(indexStart, indexEnd);
            }

            
            return new Document(filename, pages);

        }catch(IOException e){
            System.out.println("Error: Exception found!");
            e.printStackTrace();
        }

        
        return null;
    }
    
    @Override
    public String toString() {
        return "\"" + this.text[0].substring(0, (this.text[0].length() > 30) ? 30 : this.text[0].length()) + ((this.text[0].length() > 30) ? "...\"" : "\"");
    }
}
