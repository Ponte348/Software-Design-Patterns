import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Format implements ContactsStorageInterface{
    private File file;
    private String extension;
    
    /**
     * Constructor
     * @param file File
     * @return Format object
     */
    public Format(File file){
        this.file = file;
        this.extension = file.getName().split("\\.")[1];
    }

    /**
     * Load contacts from a file with a specific format
     * @return <strong>List</strong> of contacts
     * @see FormatTXT
     * @see FormatCSV
     * @see FormatJSON
     */
    @Override
    public List<Contact> loadContacts() {
        ContactsStorageInterface store = null;
        try{
            switch(extension){
                case "txt":
                    store = new FormatTXT(file);
                    break;
                case "csv":
                    store = new FormatCSV(file);
                    break;
                case "json":
                    store = new FormatJSON(file);
                    break;
                // binary
                case "bin":
                    store = new FormatBIN(file);
                    break;
                default:
                    throw new IllegalArgumentException("Format not supported");
            }
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            return new ArrayList<Contact>();
        }

        return store.loadContacts();
    }

    /**
     * Save contacts to a file with a specific format
     * @param list List of contacts
     * @return <STRONG>true</STRONG> if the contacts were saved successfully, <STRONG>false</STRONG> otherwise
     */
    @Override
    public boolean saveContacts(List<Contact> list) {
        ContactsStorageInterface store = null;
        try{
            switch(extension){
                case "txt":
                    store = new FormatTXT(file);
                    break;
                case "csv":
                    store = new FormatCSV(file);
                    break;
                case "json":
                    store = new FormatJSON(file);
                    break;
                default:
                    throw new IllegalArgumentException("Format not supported");
            }
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            return false;
        }

        return store.saveContacts(list);
    }
}
