import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsList implements ContactsInterface{
    private List<Contact> list = new ArrayList<Contact>();

    /**
     * Load contacts from a file and add them to the list
     * @param store ContactsStorageInterface
     */
    @Override
    public void openAndLoad(ContactsStorageInterface store) {
        List<Contact> contactsToAdd = store.loadContacts();
        for (Contact c : contactsToAdd) {
            if (!list.contains(c)) {
                list.add(c);
            }
        }
    }

    /**
     * Save contact list to a file
     */
    @Override
    public void saveAndClose() {
        if (list.size() > 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Save to file? (y/n): ");
            String answer = sc.nextLine();
            if (answer.equals("y")) {
                System.out.print("Enter file name: ");
                String fileName = sc.nextLine();
                
                File file = new File(fileName);
                ContactsStorageInterface store = new Format(file);
                store.saveContacts(list);
                sc.close();
            }
        }else {
            System.out.println("No contacts to save");
        }
    }

    /**
     * Save contact list to a file
     * @param store ContactsStorageInterface
     */
    @Override
    public void saveAndClose(ContactsStorageInterface store) {
        if (list.size() > 0) {
            store.saveContacts(list);
        }else {
            System.out.println("No contacts to save");
        }
    }

    /**
     * Check if a contact exists in the list
     * @param contact Contact
     * @return <STRONG>true</STRONG> if the contact exists, <STRONG>false</STRONG> otherwise
     */
    @Override
    public boolean exist(Contact contact) {
        return list.contains(contact);
    }

    /**
     * Get a contact using their name
     * @param name String
     * @return Contact
     */
    @Override
    public Contact getByName(String name) {
        for (Contact c : list) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        System.out.println("Contact not found");
        return null;
    }

    /**
     * Add a contact to the list
     * @param contact Contact
     * @return <STRONG>true</STRONG> if the contact was added successfully, <STRONG>false</STRONG> otherwise
     */
    @Override
    public boolean add(Contact contact) {
        if (!list.contains(contact)) {
            list.add(contact);
            return true;
        }
        return false;
    }

    /**
     * Remove a contact from the list
     * @param contact Contact
     * @return <STRONG>true</STRONG> if the contact was removed successfully, <STRONG>false</STRONG> otherwise
     */
    @Override
    public boolean remove(Contact contact) {
        if (list.contains(contact)) {
            list.remove(contact);
            return true;
        }
        return false;
    }


}
