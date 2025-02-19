import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Voos {

    /**
     * Method to print the help instructions
     */
    public static void printHelpInstructions() {
        System.out.println("H - Help");
        System.out.println("I filename - Reads file filename containing flight information");
        System.out.println("M flight_code - Displays reservation map of a flight");
        System.out.println("F flight_code num_seats_executive num_seats_tourist - Adds new flight. Executive seats are optional");
        System.out.println("R flight_code class number_seats - Adds seat reservation to a flight");
        System.out.println("C reservation_code - Cancels reservation. Reservation code is in the format flight_code:sequential_reservation_number");
        System.out.println("Q - Ends program execution");
    }

    /**
     * Method to read flight information from a file and create a Flight object
     * @param filename - Name of the file to read
     * @return Flight - Flight object with the information read from the file
     */
    public static Flight readFlightInformation(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            String FlightCode = "";
            Flight flight = null;

            // SeatsDimension: 0 - ExecutiveRows, 1 - ExecutiveColumns, 2 - TouristRows, 3 - TouristColumns
            int[] SeatsDimensions = new int[4];

            if (scanner.hasNextLine()) {
                String FirstLine = scanner.nextLine();
                // if firstline does not start with >, or if the flight code isn't alphanumeric, throw an exception
                if (FirstLine.charAt(0) != '>' || !FirstLine.substring(1, 7).matches("^[a-zA-Z0-9]*$")) {
                    scanner.close();
                    throw new Exception("Invalid flight!");
                }

                FlightCode = FirstLine.substring(1).split(" ")[0];

                // check if we have executive and tourist seats
                if (FirstLine.split(" ").length != 3) {
                    // we only have tourist seats
                    String TouristSeats = FirstLine.split(" ")[1];
                    SeatsDimensions = getSeatsDimensions("0x0", TouristSeats);
                }else{
                    String ExecutiveSeats = FirstLine.split(" ")[1];
                    String TouristSeats = FirstLine.split(" ")[2];
                    SeatsDimensions = getSeatsDimensions(ExecutiveSeats, TouristSeats);
                }
                flight = new Flight(FlightCode, SeatsDimensions);
            }
            

            // Flight created, now let's read the reservations
            while (scanner.hasNextLine()) {
                String[] reservation = scanner.nextLine().split(" ");
                String SeatClass = reservation[0];
                int NumberOfReservations = Integer.parseInt(reservation[1]);

                if (flight.addReservation(SeatClass, NumberOfReservations))
                    System.out.println("Reserva adicionada com sucesso!");
                else
                    System.out.println("Impossível adicionar reserva!");
            }

            scanner.close();
            return flight;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading flight information from file!");
        }
    }

    /**
     * Method to get the dimensions of the seats from a string
     * @param executiveSeats - String with the dimensions of the executive seats in format NxM
     * @param touristSeats - String with the dimensions of the tourist seats in format NxM
     * @return int[] - Array with the dimensions of the seats: 0 - ExecutiveRows, 1 - ExecutiveColumns, 2 - TouristRows, 3 - TouristColumns
     */
    private static int[] getSeatsDimensions(String executiveSeats, String touristSeats) {
        int[] SeatsDimensions = new int[4];
        if (executiveSeats.matches("^[0-9]*x[0-9]*$")) {
            SeatsDimensions[0] = Integer.parseInt(executiveSeats.split("x")[0]);
            SeatsDimensions[1] = Integer.parseInt(executiveSeats.split("x")[1]);
        } else {
            SeatsDimensions[0] = 0;
            SeatsDimensions[1] = 0;
        }

        if (touristSeats.matches("^[0-9]*x[0-9]*$")) {
            SeatsDimensions[2] = Integer.parseInt(touristSeats.split("x")[0]);
            SeatsDimensions[3] = Integer.parseInt(touristSeats.split("x")[1]);
        } else {
            SeatsDimensions[2] = 0;
            SeatsDimensions[3] = 0;
        }

        return SeatsDimensions;
    }

    public static void main(String[] args) throws Exception {
        if (args.length > 1) {
            throw new Exception("Too many arguments!");
        }

        // Se for dado um fichero de instruções, vamos adicionar as instruções a uma queue e posteriormente lê-las
        String InstructionsFilename = "";
        Queue<String> instructions = new LinkedList<String>();
        if (args.length == 1) {
            InstructionsFilename = args[0];

            File file = new File(InstructionsFilename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                instructions.add(scanner.nextLine());
            }
            scanner.close();
        }

        // Key: FlightCode, Value: Flight
        HashMap<String, Flight> Flights = new HashMap<String, Flight>();

        Scanner scanner = new Scanner(System.in);
        char option = ' ';
        String input = "";

        do{
            System.out.println("Escolha uma opção: (H para ajuda)");


            // Se ainda tivermos instruções por executar, usamos essas, caso contrário, pedimos ao user
            input = (instructions.size() > 0) ? instructions.poll() : scanner.nextLine();
            option = input.charAt(0);

            String flightCode = "";
            switch (option) {
                case 'H':
                    printHelpInstructions();
                    break;

                case 'I':
                    // print actual path
                    String[] operation = input.split(" ");
                    if (operation.length != 2) {
                        System.out.println("Opção inválida!\nI filename - Lê um ficheiro de texto contento informação sobre um voo\n");
                        break;
                    }
                    String filename = operation[1];
                    Flight flight = readFlightInformation(filename);
                    Flights.put(flight.getFlightCode(), flight);

                    System.out.println("Código de vôo: " + flight.getFlightCode() + ". Lugares disponíveis: " + flight.getTotalSeats("E") + " lugares em classe Executiva; " + flight.getTotalSeats("T") + " lugares em classe Turística");

                    break;

                case 'M':
                    flightCode = input.split(" ")[1];
                    if (Flights.containsKey(flightCode)) {
                        Flights.get(flightCode).mapFlight();
                    } else {
                        System.out.println("Vôo não encontrado!\nM flight_code - Mostra mapa de reservas de um vôo\n");
                    }
                    break;

                case 'F':
                    operation = input.split(" ");
                    if (operation.length != 4) {
                        System.out.println("Opção inválida!\nF flight_code num_seats_executive num_seats_tourist - Adiciona novo vôo. Lugares executivos são opcionais\n");
                        break;
                    }
                    flightCode = operation[1];
                    int[] seatsDimensions = getSeatsDimensions(operation[2], operation[3]);
                    Flights.put(flightCode, new Flight(flightCode, seatsDimensions));
                    break;

                case 'R':
                    System.out.println("Acrescenta reserva de lugares a um vôo");

                    operation = input.split(" ");
                    if (operation.length != 4) {
                        System.out.println("Opção inválida!\nR flight_code class number_seats - Acrescenta reserva de lugares a um vôo\n");
                        break;
                    }
                    Flight flightToReserve = Flights.get(operation[1]);
                    if (flightToReserve == null) {
                        System.out.println("Vôo não encontrado!\nR flight_code class number_seats - Acrescenta reserva de lugares a um vôo\n");
                        break;
                    }

                    String seatClass = operation[2];
                    int numberOfSeats = Integer.parseInt(operation[3]);
                    if (flightToReserve.addReservation(seatClass, numberOfSeats))
                        System.out.println("Reserva adicionada com sucesso!");
                    else
                        System.out.println("Impossível adicionar reserva!");

                    break;

                case 'C':   
                    // delete flight with code
                    operation = input.split(" ");
                    if (operation.length != 2) {
                        System.out.println("Opção inválida!\nC reservation_code - Cancela reserva. Código de reserva está no formato flight_code:sequential_reservation_number\n");
                        break;
                    }

                    String FlightCodeToCancel = input.split(" ")[1].split(":")[0];
                    int ReservationNumber = Integer.parseInt(input.split(" ")[1].split(":")[1]);

                    if (Flights.containsKey(FlightCodeToCancel)) {
                        Flights.get(FlightCodeToCancel).cancelReservation(ReservationNumber);
                    } else {
                        System.out.println("Vôo não encontrado!\nC reservation_code - Cancela reserva. Código de reserva está no formato flight_code:sequential_reservation_number\n");
                    }

                    break;

                case 'Q':
                    System.out.println("Programa terminado!");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while (option != 'Q');

        scanner.close();
    }
}
