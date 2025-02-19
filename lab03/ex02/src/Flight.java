public class Flight {
    private String FlightCode;
    private Seats[][] FlightSeats;
    private int TotalFlightReservations;


    /**
     * Constructor for Flight
     * @param flightCode - Flight code
     * @param SeatsDimensions - Array with dimensions for seats: 0 - ExecutiveColumns, 1 - ExecutiveRows, 2 - TouristColumns, 3 - TouristRows
     * @return Flight object Flight
     */
    public Flight(String flightCode, int[] SeatsDimensions) {
        this.FlightCode = flightCode;
        // SeatsDimensions: 0 - ExecutiveColumns, 1 - ExecutiveRows, 2 - TouristColumns, 3 - TouristRows
        this.FlightSeats = initializeSeats(SeatsDimensions);
        this.TotalFlightReservations = 0;
        mapFlight();
    }

    /**
     * Method to initialize the seats for the flight
     * @param SeatsDimensions - Array with dimensions for seats: 0 - ExecutiveColumns, 1 - ExecutiveRows, 2 - TouristColumns, 3 - TouristRows
     * @return Seats[][] FlightSeats - 2D array with the seats for the flight
     */
    private Seats[][] initializeSeats(int[] SeatsDimensions) {
        int executiveColumns = SeatsDimensions[0];
        int executiveRows = SeatsDimensions[1];
        int touristColumns = SeatsDimensions[2];
        int touristRows = SeatsDimensions[3];

        int totalRows = Math.max(executiveRows, touristRows);
        int totalColumns = executiveColumns + touristColumns;

        this.FlightSeats = new Seats[totalRows][totalColumns];

        for (int x = 0; x < totalRows; x++) {
            for (int y = 0; y < totalColumns; y++) {
                if (y < executiveColumns && x < executiveRows) {
                    FlightSeats[x][y] = new Seats(SeatClasses.E, 0);
                } else if (y >= executiveColumns && x < touristRows) {
                    FlightSeats[x][y] = new Seats(SeatClasses.T, 0);
                } else {
                    FlightSeats[x][y] = null;
                }
            }
        }

        return FlightSeats;
    }
    
    /**
     * Method to add a reservation to the flight
     * @param seatClass - Class of the seat
     * @param numSeatsToReserve - Number of seats to reserve
     * @return boolean - True if the reservation was 100% successful, False if it was not
     */
    public boolean addReservation(String seatClass, int numSeatsToReserve){
        mapFlight();
        SeatClasses seatClassEnum = SeatClasses.valueOf(seatClass);
        // Vamos procurar uma coluna vazia, se não houver nenhuma procuramos só um lugar vazio
        int column = getFirstEmptyColumn(seatClassEnum);
        // Não há mais lugares disponíveis
        if (column == -1) {
            return false;
        }

        this.TotalFlightReservations += 1;
        int reservedSeats = 0;

        for (int row = 0; row < FlightSeats.length; row++) {
            if (FlightSeats[row][column] != null && FlightSeats[row][column].getSeatClass() == seatClassEnum && FlightSeats[row][column].getReservationNumber() == 0) {
                FlightSeats[row][column].setReservationNumber(this.TotalFlightReservations);
                reservedSeats++;
            }

            if (reservedSeats == numSeatsToReserve) 
                return true;
            
            if (reservedSeats > 1 && reservedSeats%getNumberOfRows(seatClassEnum)==0){
                column+=1;
                row = -1;
            }
        }

        return false;
    }
    
    /**
     * Method to cancel a reservation
     * @param reservationNumber - Reservation number to cancel
     */
    public void cancelReservation(int reservationNumber){
        for (int row = 0; row < FlightSeats.length; row++) {
            for (int col = 0; col < FlightSeats[0].length; col++) {
                if (FlightSeats[row][col] != null && FlightSeats[row][col].getReservationNumber() == reservationNumber) {
                    FlightSeats[row][col].setReservationNumber(0);
                }
            }
        }
    }

    /**
     * Method to get the index of the first empty column, if there are no empty columns, it returns the index of the first empty seat
     * @param seatClass - Class of the seat
     * @return int - Index of the first empty column or seat
     */
    private int getFirstEmptyColumn(SeatClasses seatClass) {
        for (int col = 0; col < FlightSeats[0].length; col++) {
            if (FlightSeats[0][col].getSeatClass() != seatClass) {
                continue;
            }
            boolean allSeatsEmpty = true;
            for (int row = 0; row < FlightSeats.length; row++) {
                if (FlightSeats[row][col] != null){
                    if (FlightSeats[row][col].getSeatClass() == seatClass && FlightSeats[row][col].getReservationNumber() != 0) {
                        allSeatsEmpty = false;
                        break;
                    }
                }
            }
            if (allSeatsEmpty) {
                return col;
            }
        }
    
        // If there are no empty columns, return the column of the first empty seat
        return getFirstEmptySeat(seatClass);
    }

    /**
     * Method to get the index of the first empty seat
     * @param seatClass - Class of the seat
     * @return int - Index of the first empty seat
     */
    private int getFirstEmptySeat(SeatClasses seatClass) {
        for (int col = 0; col < FlightSeats[0].length; col++) {
            for (int row = 0; row < FlightSeats.length; row++) {
                if (FlightSeats[row][col] != null && FlightSeats[row][col].getSeatClass() == seatClass && FlightSeats[row][col].getReservationNumber() == 0) {
                    return col;
                }
            }
        }
        return -1;
    }


    /**
     * Method to get the number of rows for a specific seat class in the flight
     * @param seatClass - Class of the seat
     * @return int - Number of rows for the specific seat class
     */
    private int getNumberOfRows(SeatClasses seatClass) {
        int numberOfRows = 0;
        for (int row = 0; row < FlightSeats.length; row++) {
            for (int col = 0; col < FlightSeats[0].length; col++) {
                if (FlightSeats[row][col] != null && FlightSeats[row][col].getSeatClass() == seatClass) {
                    numberOfRows++;
                    break;
                }
            }
        }
        return numberOfRows;
    }

    /**
     * Method to get number of total seats for a specific class
     * @param seatClass - Class of the seat
     * @return int - Number of total seats for the specific class
     */
    public int getTotalSeats(String seatClass){
        SeatClasses seatClassEnum = SeatClasses.valueOf(seatClass);
        int totalSeats = 0;
        for (int row = 0; row < FlightSeats.length; row++) {
            for (int col = 0; col < FlightSeats[0].length; col++) {
                if (FlightSeats[row][col] != null && FlightSeats[row][col].getSeatClass() == seatClassEnum) {
                    totalSeats++;
                }
            }
        }
        return totalSeats;
    }

    /**
     * Method to print the flight
     */
    public void mapFlight(){
        System.out.printf("%s\n", this.FlightCode); //print the flight code
        
        System.out.print(" ");
        for (int i = 0; i < this.FlightSeats[0].length; i++) {
            System.out.printf("%3d", i + 1);
        }
        System.out.println();
        
        char c = 'A';
        for(int i=0; i<this.FlightSeats.length; i++){ //iterate through rows
            System.out.printf("%c", c); //print row letter

            for(int j=0; j<this.FlightSeats[i].length; j++){ //iterate through columns
                if (this.FlightSeats[i][j] != null) {
                    //print class
                    //System.out.print(this.FlightSeats[i][j].getSeatClass() == SeatClasses.E ? " E" : " T");
                    //System.out.printf("%d", this.FlightSeats[i][j].getReservationNumber());

                    System.out.printf("%3d", this.FlightSeats[i][j].getReservationNumber());
                } else {
                    System.out.print("   "); // print empty space for null seats
                }
            }
            System.out.println();
            c++;
        }
    }


    public String getFlightCode() {
        return FlightCode;
    }
    public void setFlightCode(String flightCode) {
        FlightCode = flightCode;
    }
    public Seats[][] getFlightSeats() {
        return FlightSeats;
    }
    public void setFlightSeats(Seats[][] flightSeats) {
        FlightSeats = flightSeats;
    }
}
