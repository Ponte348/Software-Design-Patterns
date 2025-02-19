import java.util.ArrayList;
import java.util.List;

public class printerAdapter implements AdvancedPrinterInterface{

    private BasicPrinter basicPrinter;
    private List<PrintJob> jobsToPrint;

    private printerAdapter(BasicPrinter basicPrinter){
        this.basicPrinter = basicPrinter;
        jobsToPrint = new ArrayList<PrintJob>();
    }

    public static printerAdapter createPrinterAdapter(BasicPrinter basicPrinter){
        return new printerAdapter(basicPrinter);
    }

    @Override
    public int print(Document document){
        System.out.println("Spooling 1 document");
        PrintJob newJob = PrintJob.createPrintJob(document);
        if(this.basicPrinter.print(document.text)){
            jobsToPrint.remove(newJob);
        }
        
        return newJob.getID();
    }
    
    @Override
    public List<Integer> print(List<Document> documents){
        System.out.println("Spooling" + documents.size() + "documents");
        List<Integer> jobsList = new ArrayList<Integer>();
        for(Document document : documents){
            PrintJob newJob = PrintJob.createPrintJob(document);
            jobsToPrint.add(newJob);
            if(this.basicPrinter.print(document.text)){
                jobsList.add(newJob.getID());
            }
        }
        return jobsList;
    }

    @Override
    public void showQueuedJobs(){
        System.out.println("Spooled jobs: ");
        for(PrintJob job : this.jobsToPrint){
            System.out.println("\t* "+job);
        }
        System.out.print("\n");
    }

    @Override
    public boolean cancelJob(int id){
        for(PrintJob job : this.jobsToPrint){
            if(job.getID() == id){
                return this.jobsToPrint.remove(job);
            }
        }
        return false;
    }

    @Override
    public void cancelAll(){
        System.out.println("Job rejected by spool: service shutting down?");
        this.jobsToPrint.clear();
    }
}
