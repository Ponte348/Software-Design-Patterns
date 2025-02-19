package Ex2;
import java.util.Scanner;
import java.io.File;
public class App {

    static GerenciadorVoos voosGerenciador = new GerenciadorVoos();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter an option (H for help): ");
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            String option = inputArray[0].toUpperCase();
            switch(option) {
                case "H":
                    System.out.println("----- HELP ------");
                    System.out.println("List of commands available: ");
                    System.out.println("I filename -> reads a file that contains flight data.");
                    System.out.println("M flight_code -> shows the map of seats of a flight (seats with '0' are seats available).");
                    System.out.println("F flight_code num_seats_executive num_seats_tourist -> adds a new flight (executive seats are optional).");
                    System.out.println("R flight_code class number_seats -> adds a reservation to a specific flight");
                    System.out.println("C reservation_code -> cancels a reservation with a code (code format 'flight_code:sequential_reservation_number')");
                    System.out.println("Q -> Quits the program");
                    System.out.println("H -> Shows this help");
                    break;
                case "I":
                    if (inputArray.length != 2) {
                        System.out.println("Invalid option! ONE argument (filename) is expected. Type H for help.");
                        break;
                    }
                    String fileName = inputArray[1];
                    readFile(fileName);
                    break;
                case "M":
                    if (inputArray.length != 2) {
                        System.err.println("Invalid option! ONE argument (filename) is expected. Type H for help.");
                        break;
                    }
                    String code= inputArray[1];
                    Voo voo = voosGerenciador.getVoo(code);
                    if(voo != null){
                        voosGerenciador.getVoo(code).show_bookingmap();
                    } else {
                        System.out.println("Voo não existe");
                        System.out.println();
                        return;
                    }
                    break;
                case "F":
                    if  (inputArray.length != 3 && inputArray.length != 4) {
                        System.out.println("Invalid option! TWO or THREE arguments are expected. Type H for help.");
                        break;
                    }
                    adicionarVoo(inputArray);
                    break;

                case "R":
                    if (inputArray.length != 4) {
                        System.err.println("Invalid option! FOUR arguments are expected <flight_code> <class> <num_seats>. Type H for help.");
                        System.out.println();
                        return;
                    }
                    String codeVoo= inputArray[1];
                    String classe= inputArray[2].toUpperCase();
                    char cl= classe.charAt(0);
                    String num_reservas= inputArray[3];
                    voo = voosGerenciador.getVoo(codeVoo);
                    int numSeats = Integer.parseInt(num_reservas);
                    if(voo != null){
                        String[] reservedSeats = voo.ReserveSeats(cl, numSeats);
                        if (reservedSeats != null) {
                            voo.printSeats(reservedSeats, codeVoo);
                        }
                    } else {
                        System.out.println("Voo não existe");
                        System.out.println();
                        return;
                    }
                    break;
                case "C":
                    if (inputArray.length != 2) {
                        System.out.println("Invalid option! ONE argument (reservation_code with format 'flight_code' ) is expected. Type H for help.");
                        break;
                    }
                    if (!inputArray[1].matches("^[A-Za-z0-9]+:[0-9]+$")) {
                        System.out.println("Invalid reservation code format. Format should be 'flight_code:sequential_reservation_number'");
                    }
                    String[] reservationCode = inputArray[1].split(":");
                    String flightCode = reservationCode[0];
                    int reservationNumber = Integer.parseInt(reservationCode[1]);
                    voosGerenciador.cancelReservation(reservationNumber, flightCode);
                    break;

                case "Q":
                    System.out.println("Quitting the program...");
                    System.exit(0);
                    
                    break;
                
                default:
                    System.out.println("Invalid option - type H for help.");
            }
        }
        
    }

    public static void readFile(String fileName) {
        try {
            File flight = new File(fileName);
            Scanner scanner = new Scanner(flight);
            String firstLine = scanner.nextLine();
            if (firstLine.charAt(0) != '>'){
                System.out.println("Ficheiro inválido");
                System.exit(0);
            }
            firstLine = firstLine.substring(1);
            String[] flightInfo = firstLine.split(" ");
            String flightCode = flightInfo[0];
            Plane plane;
            Voo voo = null;
            if (flightInfo.length == 3) {
                int lugaresFilaExecutiva = Integer.parseInt(flightInfo[1].split("x")[1]);
                int numFilasExecutivas = Integer.parseInt(flightInfo[1].split("x")[0]);
                int lugaresFilaTourista = Integer.parseInt(flightInfo[2].split("x")[1]);
                int numFilasTourista = Integer.parseInt(flightInfo[2].split("x")[0]);
                plane = new Plane(numFilasTourista, lugaresFilaTourista, numFilasExecutivas, lugaresFilaExecutiva);
                voo = new Voo(plane, flightCode);
                System.out.println(voo.toString());
                voosGerenciador.addVoo(voo);
  
            }  
            else if (flightInfo.length == 2) {
                int LugaresFilaTourista = Integer.parseInt(flightInfo[1].split("x")[1]);
                int numFilasTourista = Integer.parseInt(flightInfo[1].split("x")[0]);
                plane = new Plane(numFilasTourista, LugaresFilaTourista);
                voo = new Voo(plane, flightCode);
                System.out.println(voo.toString());
                voosGerenciador.addVoo(voo);

            }
            else {
                System.out.println("Invalid file format");
                System.exit(0);
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] seatsReserved = line.split(" ");
                if (seatsReserved.length != 2) {
                    System.out.println("Invalid file format");
                    System.exit(0);
                }
                char classe = seatsReserved[0].charAt(0);
                int numberSeats = Integer.parseInt(seatsReserved[1]);
                voo.ReserveSeats(classe, numberSeats);
            }
            scanner.close();
        } catch (Exception fileException) {
            System.out.println("Error!!");
            fileException.printStackTrace();
    }
    }

    public static void adicionarVoo(String[] inputArray) {
        String flightCode = inputArray[1];
        Voo voo = voosGerenciador.getVoo(flightCode);
        if (voo != null) {
            System.out.println("Flight already exists, insert a different flight.");
            return;
        }
        if (inputArray.length == 3) {
            int LugaresFilaTourista = Integer.parseInt(inputArray[1].split("x")[0]);
            int numFilasTourista = Integer.parseInt(inputArray[1].split("x")[1]);
            Plane plane = new Plane(numFilasTourista, LugaresFilaTourista);
            voo = new Voo(plane, flightCode);
            voosGerenciador.addVoo(voo);
            System.out.println("Flight " + flightCode + " created with" + LugaresFilaTourista + "x" + numFilasTourista + " seats.");
        }
        else if (inputArray.length == 4) {
            int lugaresFilaExecutiva = Integer.parseInt(inputArray[1].split("x")[0]);
            int numFilasExecutivas = Integer.parseInt(inputArray[1].split("x")[1]);
            int lugaresFilaTourista = Integer.parseInt(inputArray[2].split("x")[0]);
            int numFilasTourista = Integer.parseInt(inputArray[2].split("x")[1]);
            Plane plane = new Plane(numFilasTourista, lugaresFilaTourista, numFilasExecutivas, lugaresFilaExecutiva);
            voo = new Voo(plane, flightCode);
            voosGerenciador.addVoo(voo);
            System.out.println("Flight " + flightCode + " created " + lugaresFilaExecutiva + "x" + numFilasExecutivas + " executive seats and " + lugaresFilaTourista + "x" + numFilasTourista + " tourist seats.");
        }
        else {
            System.out.println("Invalid option! TWO or THREE arguments are expected. Type H for help.");
        }

    }

}