public class PrintJob implements Runnable {
    
    private final Document document;
    private Integer id;
    private static int count = 0;

    private PrintJob(Document document){
        this.document = document;
        this.id = count++;
    }

    public static PrintJob createPrintJob(Document document){
        return new PrintJob(document);
    }

    public Document getDocument(){
        return this.document;
    }

    public int getID(){
        return this.id;
    }

    @Override
    public void run(){
        System.out.println("Finished" + this);
    }

    @Override
    public String toString() {
        return ("Job " + this.getID() + ": " + this.getDocument());
    }
}
