import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Airport {

    private static FlightManager Fmanager = new FlightManager();
    private static ReservationsManager Rmanager = new ReservationsManager();

    public static void main(String args[]){
        if(args.length==1){
            readCommandFile(args[0]);
        }
        else{
            readTerminal();
        }
    }
    /**
     * Reads a commandfile as an input argument
     * @param filename - file name
     */
    public static void readCommandFile(String filename){
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String line = read.nextLine();
                Scanner sline = new Scanner(line);
                String option = menu(sline);
                if(option.equals("Q")){
                    break;
                }
            }
            read.close();
        }
        catch (FileNotFoundException e){
            System.err.println("Error- ficheiro inválido");
            System.exit(1);
        }
    }
    /**
     * Menu options and what functions they call
     * @param line - o input do utilizador
     * @return option - a opção do menu que o utilizador escolheu
     */
    public static String menu(Scanner line){
        String option = line.next();
        switch (option){
            case "H":
                showMenu();
                break;
            case "I":
                readFile(line);
                break;
            case "M":
                showPlaneMap(line);
                break;
            case "F":
                newPlane(line);
                break;
            case "R":
                newReservation(line);
                break;
            case "C":
                cancelReservation(line);
                break;
        }
        return option;
    }

    /**
     * Works by terminal
     */
    public static void readTerminal(){
        String choice="A";
        Scanner sc = new Scanner(System.in);
        while(!choice.equals("Q")){
            System.out.println("Escolha uma opção: (H para ajuda)");
            String line = sc.nextLine();
            Scanner sline = new Scanner(line);
            choice = menu(sline);
        }
        sc.close();
    }
    /**
     * Help menu
     */
    public static void showMenu(){
        System.out.println("H - apresenta as opções do menu");
        System.out.println();
        System.out.println("I *filename* - lê um ficheiro contendo informação sobre um voo");
        System.out.println();
        System.out.println("M *flight_code* - exibe o mapa das reservas de um voo");
        System.out.println();
        System.out.println("F *flight_code* *num_seats_executive* *num_seats_tourist* - acrescenta um voo manualmente");
        System.out.println();
        System.out.println("R *flight_code* *class* *numbe_seats* - acrescenta uma nova reserva a um voo");
        System.out.println();
        System.out.println("C *reservation_code*(flight_code:sequential_reservation_number) - cancela uma reserva");
        System.out.println();
        System.out.println("Q - termina o programa");
    }

    /**
     * Reads a file with the information of a flight
     * @param line - input do utilizador (sem a opção)
     */
    public static void readFile(Scanner line){
        ArrayList<String> notAvailable = new ArrayList<String>();
        String code;
        if(!line.hasNext()){
            System.out.println("Error - Escreva o nome do ficheiro");
            return;
        }
        File file = new File(line.next());
        try{
            Scanner read = new Scanner(file);
            String firstline = read.nextLine();
            if(!validFirstLine(firstline)){
                System.err.println("Error - Formato inválido");
                showFileRules();
                read.close();
                return;
            }
            code = readFirstLine(firstline.substring(1));
            System.out.println(printOption_I_output(code));
            while(read.hasNextLine()){
                String linha = read.nextLine();
                Reservation reserva = getReservations(code, linha);
                if(reserva==null){
                    notAvailable.add(linha);
                }
            }
            read.close();
        }
        catch (FileNotFoundException e){
            System.err.println("Error - Ficheiro não válido");
            return;
        }
        printFailedReservations(notAvailable);
    }

    public static boolean validFirstLine(String line){
        return line.charAt(0) == '>';
    }
    /**
     * Show the rules for a valid input file
     */
    public static void showFileRules(){
        System.out.println("A primeira linha do ficheiro deve começar com o caracter \">\" e indicar o código de voo, o número de filas");
        System.out.println(" e lugares por fila em classe executiva (caso exista) e o número de filas e lugares por fila em classe turística.");
        System.out.println("As linhas seguintes, caso existam, contêm reservas já efetuadas, no formato classe, número de lugares, como se vê nos exemplos. ");
        System.out.println();
        File file = new File("flight1.txt");
        try{
            Scanner printer = new Scanner(file);
            while(printer.hasNextLine()){
                System.out.println(printer.nextLine());
            }
            printer.close();
        }
        catch (FileNotFoundException e){
            System.err.println("Não é suposto isto acontecer");
            System.exit(1);
        }
    }

    /**
     * Read the first line of the input file (with the plane bd)
     * @param line - the first line
     * @return code - the code from the flight
     */
    public static String readFirstLine(String line){
        String code, firstinput_seats, eSeats="", tSeats="";
        Scanner info = new Scanner(line);
        code = info.next();
        firstinput_seats = info.next();
        if(info.hasNext()){
            eSeats = firstinput_seats;
            tSeats = info.next();
        }
        else{
            tSeats = firstinput_seats;
        }
        addNewFlight(code,eSeats,tSeats);
        info.close();
        return code;
    }

    /**
     * Add a new flight
     * @param code - flight code
     * @param eSeats - Executive class seats information
     * @param tSeats - Turistic class seats information
     */
    public static void addNewFlight(String code, String eSeats, String tSeats){
        ArrayList<Integer[]> seatsInfo = new ArrayList<Integer[]>();
        ArrayList<String> classesInfo = new ArrayList<String>();
        String[] tSeatsInfo = tSeats.split("x");
        Integer[] tseats = {Integer.parseInt(tSeatsInfo[0]), Integer.parseInt(tSeatsInfo[1])};
        if(!eSeats.equals("")){
            String[] eSeatsInfo = eSeats.split("x");
            Integer[] eseats = {Integer.parseInt(eSeatsInfo[0]), Integer.parseInt(eSeatsInfo[1])};
            seatsInfo.add(eseats);
            classesInfo.add("E");
        }
        seatsInfo.add(tseats);
        classesInfo.add("T");
        Fmanager.createNewFlight(seatsInfo,classesInfo,code);
    }

    /**
     * Tries to add a new reservation to an specific flight
     * @param code - flight code
     * @param line - reservation information
     * @return {@code reservation} if reservation was possible
     *         <li>
     *         {@code null} if reservation was not possible
     */
    public static Reservation getReservations(String code, String line){
        String type = line.split(" ")[0];
        String nSeats = line.split(" ")[1];
        Reservation reserva;
        ClassCategory classe = validSeat(type);
        if(classe==null){
            return null;
        }
        reserva = Rmanager.createNewReservation(code, Integer.parseInt(nSeats), classe);
        if(Fmanager.attemptReservation(reserva)){
            return reserva;
        }
        return null;
    }
    /**
     * Checks if the Class of the resevation it's valid
     * @param type - Class type
     * @return {@code class} if {@code type} is a valid seat
     *         <li>
     *         {@code null} if {@code type} is invalid
     */
    public static ClassCategory validSeat(String type){
        for(ClassCategory classe : ClassCategory.values()) {
            if(ClassCategory.getClassLetter(classe).equals(type)){
                return classe;
            }
        }
        return null;
    }
    /**
     * Print the information from a flight
     * @param code - flight code
     * @return The information from the flight
     */
    public static String printOption_I_output(String code){
        return Fmanager.getFlightFromCode(code).toString();
    }

    /**
     * Print all the failed reservations
     * @param fail - All failed reservations
     */
    public static void printFailedReservations(ArrayList<String> fail){
        System.out.print("Não foi possível obter lugares para a reserva : ");
        for(int i = 0; i<fail.size();i++){
            System.out.print("|" + fail.get(0) + "| ");
        }
        System.out.println();
    }

    /**
     * Prints the plane map
     * @param line - Flight code
     */
    public static void showPlaneMap(Scanner line){
        String code = line.next();
        Flight voo = Fmanager.getFlightFromCode(code);
        if(voo==null){
            System.err.println("Error- código inválido");
            return;
        };
        System.out.println(voo.getPlane().toString());
    }

    /**
     * Adds a new plane
     * @param line - first line
     */
    public static void newPlane(Scanner line){
        String firsline = line.nextLine();
        readFirstLine(firsline.substring(1));
    }

    /**
     * adds a new reservation and prints the outcome
     * @param line - flight_code class number_seats
     */
    public static void newReservation(Scanner line){
        String code=line.next();
        String res = line.nextLine().substring(1);
        Reservation reserva = getReservations(code, res);
        if(reserva!=null){
            int id = reserva.getSequentialReservationNumber();
            System.out.print(code+":"+ id + "= ");
            ArrayList<Integer[]> lugares = Fmanager.getSeatsInPlaneByID(reserva);
            String seats = outputReservation(lugares);
            System.out.println(seats);
        } 
        else{
            System.out.println("Não foi possível efetuar a reserva");
        }
    }

    /**
     * Prints the seats information of an specific reservation
     * @param lugares - seats information
     * @return seats information
     */
    public static String outputReservation(ArrayList<Integer[]> lugares){
        String res = "";
        for(int seat = 0;seat<lugares.size();seat++){
            res += lugares.get(seat)[0];
            res += getSeatName(lugares.get(seat)[1]);
            res += " | ";
        }
        res = res.substring(0,res.length()-3);
        return res;
    }
    /**
     * Int to String
     * @param row - seat
     * @return String
     */
    public static String getSeatName(int row){
        String res = "";
        int aux_row = row;
        while (row > 25){
            aux_row = row % 25;
            res += Character.toString((aux_row + 65));
            row /= 25;
        }
        res += Character.toString(row + 65);
        return res;
    }

    /**
     * Cancel a reservation from a flight
     * @param line - reservation_code
     */
    public static void cancelReservation(Scanner line){
        String read = line.nextLine().substring(1);
        String code = read.split(":")[0];
        int seqNumber = Integer.parseInt(read.split(":")[1]);
        Reservation res = Rmanager.getRerservationForFlight(code, seqNumber);
        if(res!=null){
            Fmanager.getFlightFromCode(code).getPlane().cancelReservations(res);
            System.out.println("Reserva cancelada com sucesso!");
        }
        else{
            System.out.println("Essa reserva não existe");
        }
    }
}