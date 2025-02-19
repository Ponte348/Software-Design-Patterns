import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormatCSV extends Format{
    private File file;

    /**
     * Constructor
     * @param file File
     * @return FormatCSV object
     * @see Format
     */
    public FormatCSV(File file){
        super(file);
        this.file = file;
    }

    /**
     * Load contacts from a csv file
     * @return <strong>List</strong> of contacts
     */
    @Override
    public List<Contact> loadContacts() {
        List<Contact> list = new ArrayList<>();
        try{
            Scanner sc = new Scanner(file);
            String line;
            while(sc.hasNextLine()){
                line = sc.nextLine();
                if (line.matches("\\D+,[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6},\\d{9}")) {
                    String[] parts = line.split(",");
                    list.add(new Contact(parts[0], parts[1], parts[2]));
                }
            }
            sc.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Save contacts to a csv file
     * @param list List of contacts
     * @return <STRONG>true</STRONG> if the contacts were saved successfully, <STRONG>false</STRONG> otherwise
     */
    @Override
    public boolean saveContacts(List<Contact> list) {
        try{
            FileWriter fw = new FileWriter(file);
            for(Contact c : list){
                fw.write(c.getName() + "," + c.getPhone() + "," + c.getEmail() + "\n");
            }
            fw.close();
            return true;
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
}
