import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormatJSON extends Format{
    private File file;

    /**
     * Constructor
     * @param file File
     * @return FormatCSV object
     * @see Format
     */
    public FormatJSON(File file){
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
                if (line.startsWith("{") && line.endsWith("}")) {
                    line = line.substring(1, line.length() - 1); //remove the curly braces
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        String name = parts[0].split(":")[1].trim().replace("\"", "");
                        String email = parts[1].split(":")[1].trim().replace("\"", "");
                        String phoneNumber = parts[2].split(":")[1].trim().replace("\"", "");
                        // check if we already have this contact
                        if(!list.contains(new Contact(name, email, phoneNumber))){
                            list.add(new Contact(name, email, phoneNumber));
                        }
                    }
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
            StringBuilder sb = new StringBuilder();
            for(Contact c : list){
                sb.append("{\"name\": \"" + c.getName() + "\", \"email\": \"" + c.getEmail() + "\", \"phone\": \"" + c.getPhone() + "\"},\n");
            }
            // Remove the last comma and newline
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 2);
                sb.append("\n");
            }
            fw.write(sb.toString());
            fw.close();
            return true;
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
}
