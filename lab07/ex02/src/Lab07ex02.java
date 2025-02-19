import java.io.File;

public class Lab07ex02 {
    public static void main(String[] args) {
        ContactsList listaContactos = new ContactsList();

        File csvreadfile = new File("contactstest.csv");
        ContactsStorageInterface csvreadstorage = new Format(csvreadfile);
        listaContactos.openAndLoad(csvreadstorage);
    
        File txtreadfile = new File("contactstest.txt");
        ContactsStorageInterface txtreadstorage = new Format(txtreadfile);
        listaContactos.openAndLoad(txtreadstorage);


        File txtfile = new File("contactosGuardados.txt");
        ContactsStorageInterface txtstorage = new FormatTXT(txtfile);

        File csvfile = new File("contactosGuardados.csv");
        ContactsStorageInterface csvstorage = new FormatCSV(csvfile);

        File binfile = new File("contactosGuardados.bin");
        ContactsStorageInterface binstorage = new FormatBIN(binfile);

        File jsonfile = new File("contactosGuardados.json");
        ContactsStorageInterface jsonstorage = new FormatJSON(jsonfile);
        
        Contact beatriz = new Contact("Beatriz", "beatriz@ua.pt", "912345678");
        listaContactos.add(beatriz);
        
        Contact testBeatriz = listaContactos.getByName("Beatriz");
        System.out.print("Test getByName: ");
        System.out.println(testBeatriz.equals(beatriz));
        
        listaContactos.remove(beatriz);
        System.out.print("Test remove: ");
        System.out.println(!listaContactos.exist(beatriz));
        
        // Save files for further testing
        listaContactos.saveAndClose(txtstorage);
        listaContactos.saveAndClose(csvstorage);
        listaContactos.saveAndClose(jsonstorage);
        listaContactos.saveAndClose(binstorage);


        // Test the TXT file
        try {
            listaContactos.openAndLoad(txtstorage);

            Contact pokemon = new Contact("Pikachu", "pikachu@ua.pt", "983256978");
            listaContactos.add(pokemon);

            listaContactos.saveAndClose(txtstorage);

            listaContactos.openAndLoad(txtstorage);
            System.out.print("Test TXT file: ");
            System.out.println(listaContactos.exist(pokemon));
        } catch (Exception e) {
            System.out.println("To test the reading of a TXT file, first save the contactos to 'contactosGuardados.json'");
            e.printStackTrace();
        }

        // Test the JSON file
        try {
            listaContactos.openAndLoad(jsonstorage);

            Contact professor = new Contact("António Neves", "an@ua.pt", "960743665");
            listaContactos.add(professor);

            
            listaContactos.saveAndClose(jsonstorage);

            listaContactos.openAndLoad(jsonstorage);
            
            System.out.print("Test JSON file: ");
            System.out.println(listaContactos.exist(professor));
        } catch (Exception e) {
            System.out.println("To test the reading of a JSON file, first save the contactos to 'contactosGuardados.json'");
            e.printStackTrace();
        }

        // Test the CSV file
        try {
            listaContactos.openAndLoad(csvstorage);

            Contact rapper = new Contact("Kendrick Lamar", "pglang@ua.pt", "976854322");
            listaContactos.add(rapper);

            listaContactos.saveAndClose(csvstorage);

            listaContactos.openAndLoad(csvstorage);
            System.out.print("Test CSV file: ");
            System.out.println(listaContactos.exist(rapper));
        } catch (Exception e) {
            System.out.println("To test the reading of a CSV file, first save the contactos to 'contactosGuardados.json'");
            e.printStackTrace();
        }

        // Test the binary file
        try {
            listaContactos.openAndLoad(binstorage);
            
            Contact melhordomundo = new Contact("Cristiano Ronaldo", "ronaldo@ua.pt", "954760989");
            listaContactos.add(melhordomundo);

            listaContactos.saveAndClose(binstorage);

            listaContactos.openAndLoad(binstorage);
            System.out.print("Test binary file: ");
            System.out.println(listaContactos.exist(melhordomundo));

        } catch (Exception e) {
            System.out.println("To test the reading of a BIN file, first save the contactos to 'contactosGuardados.json'");
            e.printStackTrace();
        }
    }
}