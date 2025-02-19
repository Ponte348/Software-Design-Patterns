import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FormatBIN extends Format{
    private File file;

    /**
     * Constructor
     * @param file File
     * @return FormatCSV object
     * @see Format
     */
    public FormatBIN(File file){
        super(file);
        this.file = file;
    }

    /**
     * Load contacts from a binary file
     * @return <strong>List</strong> of contacts
     */
    @Override
    public List<Contact> loadContacts() {
        List<Contact> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                // if we already have this contact, we don't add it
                if (list.contains((Contact) ois.readObject())) {
                    continue;
                }
                list.add((Contact) ois.readObject());
            }
        } catch (EOFException e) {
            // End of file
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Save contacts to a binary file
     * @param list List of contacts
     * @return <STRONG>true</STRONG> if the contacts were saved successfully, <STRONG>false</STRONG> otherwise
     */
    @Override
    public boolean saveContacts(List<Contact> list) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Contact c : list) {
                oos.writeObject(c);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
