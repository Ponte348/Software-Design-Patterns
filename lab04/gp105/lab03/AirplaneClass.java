import java.util.ArrayList;

public class AirplaneClass {
    final int EMPTYSEAT = 0;
    ClassCategory description;
    Integer startingRow;
    Integer rows;
    Integer seatsInRow;
    Integer seats[][];
    Integer totalSeats;

    Integer emptySeats;

    /**
     * Makes class with a description, starting in first row <p> <STRONG> Should only be invoked by Plane </STRONG>
     * @param description - Turistic / Executive / Other
     * @param rows - number of rows
     * @param seatsInRow - number of seats per row
     */
    AirplaneClass(ClassCategory description, int rows, int seatsInRow){
        this.description = description;
        this.rows = rows;
        this.seatsInRow = seatsInRow;
        this.seats = new Integer[rows][seatsInRow];
        initializeArray(0);
        this.startingRow = 1;
        this.emptySeats = rows * seatsInRow;
        this.totalSeats = rows * seatsInRow;
    }

    /**
     * Makes class with no description, Turistic by default, starting in first row <p> <STRONG> Should only be invoked by Plane </STRONG>
     * @param rows - number of rows
     * @param seatsInRow - number of seats per row
     */
    AirplaneClass(int rows, int seatsInRow){
        this(ClassCategory.TURISTIC, rows, seatsInRow);
    }

    /**
     * Makes class with a description <p> <STRONG> Should only be invoked by Plane </STRONG>
     * @param description - Turistic / Executive / Other
     * @param rows - number of rows
     * @param seatsInRow - number of seats per row
     * @param startingRow - first row within the airplane
     */
    AirplaneClass(ClassCategory description, int rows, int seatsInRow, int startingRow){
        this(description, rows, seatsInRow);
        this.startingRow = startingRow;
    }

    /**
     * Makes class with no description, Turistic by default <p> <STRONG> Should only be invoked by Plane </STRONG>
     * @param rows - number of rows
     * @param seatsInRow - number of seats per row
     * @param startingRow - first row within the airplane
     */
    AirplaneClass(int rows, int seatsInRow, int startingRow){
        this(ClassCategory.TURISTIC, rows, seatsInRow, startingRow);
    }

    /**
     * Initializes seats array. Only to be used in constructor.
     * <p>
     * <STRONG>USE WITH CAUTION, THIS OVERRIDES EVERY SEAT VALUE</STRONG>
     * @param value - value to be used to initialize the array
     */
    private void initializeArray(int value){
        for (int x = 0; x < this.rows; x++){
            for (int y = 0; y < this.seatsInRow; y++){
                this.seats[x][y] = value;
            }
        }
    }
    
    /**
     * Gets the owner of a certain seat
     * @param row - row of the seat
     * @param seat - seat within row
     * @return Integer - owner of the seat
     */
    public Integer seatOwner(int row, int seat){
        return this.seats[row][seat];
    }


    /**
     * Allocates seat to owner if there is nobody sitting in there already
     * @param owner
     * @param row
     * @param seat
     * @return  {@code true} if allocation was successful 
     *          <li> 
     *          {@code false} if someone already owned the seat
     */
    public boolean allocateSeat(int owner, int row, int seat){
        if (emptySeat(row, seat)){
            this.seats[row][seat] = owner;
            return true;
        }
        return false;
    }

    /**
     * Given an ID (sequential number) returns an Array List with all the seats occupied by this number.
     * <p>
     * Each element of the array is an Integer[] with entries [row, seatInRow].
     * @param ID - sequential number attributed to reservation upon acceptance
     * @return Array List with all seats the reservation is associated with.
     */
    public ArrayList<Integer[]> getSeatsByID(int ID){
        ArrayList<Integer[]> res = new ArrayList<Integer[]>();
        for (int row = 0; row < this.getRows(); row++){
            for (int seatsPerRow = 0; seatsPerRow < this.getSeatsInRow(); seatsPerRow++){
                if (seatOwner(row, seatsPerRow) == ID){
                    Integer[] pair = new Integer[2];
                    pair[0] = row + this.getStartingRow() + 1;
                    pair[1] = seatsPerRow;
                    res.add(pair);
                }
            }
        }
        return res;
    }

    /**
     * Cancels reservation from the specified owner. Every seat they previously owned will become empty
     * <p>
     * Does nothing if ownerID is {@code EMPTYSEAT}
     * @param ownerID
     */
    public void deallocateSeats(int ownerID){
        if (ownerID == EMPTYSEAT) return;
        for (int row = 0; row < getRows(); row++){
            for (int seatsInRow = 0; seatsInRow < getSeatsInRow(); seatsInRow++){
                if (seatOwner(row, seatsInRow) == ownerID){
                    this.seats[row][seatsInRow] = EMPTYSEAT;
                    this.emptySeats++;
                }
            }
        }
    }

    /**
     * Determines whether a certain seat is empty or not
     * @param row - row where the seat is located
     * @param seatInRow - seat within the row
     * @return  {@code true} if seat is empty
     *          <li>
     *          {@code false} otherwise
     */
    public boolean emptySeat(int row, int seatInRow) {
        return seatOwner(row, seatInRow) == EMPTYSEAT;
    }

    public boolean emptyRow(int row){
        for (int seatInRow = 0; seatInRow < this.getSeatsInRow(); seatInRow++){
            if (seatOwner(row, seatInRow) != EMPTYSEAT) return false;
        }
        return true;
    }

    /**
     * Allocates seats to a certain owner, if possible
     * @param numberPeople - number of seats the owner needs
     * @param ownerID - ID of the owner
     * @return  {@code true} if allocation was successful
     *          <li>
     *          {@code false} otherwise
     */
    public boolean newReservation(int numberPeople, int ownerID){
        if (numberPeople > this.emptySeats) return false;
        for (int row = 0; row < this.getRows(); row++){
            if (emptyRow(row)) {
                int auxNumberPeople = (numberPeople > getSeatsInRow()) ? getSeatsInRow() : numberPeople;
                if (allocateRow(ownerID, auxNumberPeople, row)) numberPeople -= auxNumberPeople;
            }
        }
        if (numberPeople > 0){
            for (int newOwner = 0; newOwner < numberPeople; newOwner++){
                if(!allocateSeats(ownerID)) {
                    deallocateSeats(ownerID);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Allocates 1 seat within the plane
     * @param ownerID - ID of the new seat's owner
     */
    public boolean allocateSeats(int ownerID){
        for (int row = 0; row < getRows(); row++){
            for (int seatsInRow = 0; seatsInRow < getSeatsInRow(); seatsInRow++){
                if (allocateSeat(ownerID, row, seatsInRow)) {this.emptySeats--; return true;}
            }
        }
        return false;
    }

    public boolean allocateRow(int ownerID, int numberPeople, int row){
        for (int person = 0; person < numberPeople; person++){
            if (!allocateSeat(ownerID, row, person)) {deallocateSeats(ownerID); return false;}
        }
        return true;
    }

    /**
     * Getter for Class Description
     * @return String - Description of class
     */
    public ClassCategory getDescription() {
        return this.description;
    }

    /**
     * Setter for Class Description
     * @param description - Description of class
     */
    public void setDescription(ClassCategory description) {
        this.description = description;
    }

    /**
     * Getter for Number of Rows
     * @return Integer - number of rows within the class
     */
    public Integer getRows() {
        return rows;
    }

    /**
     * Setter for Number of Rows
     * @param rows - number of rows within the class
     */
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     * Getter for Number of Seats per Row
     * @return Integer - number of seats per row
     */
    public Integer getSeatsInRow() {
        return seatsInRow;
    }

    /**
     * Setter for Number of Seats per Row
     * @param seatsInRow - number of seats per row
     */
    public void setSeatsInRow(Integer seatsInRow) {
        this.seatsInRow = seatsInRow;
    }

    /**
     * Getter for Starting Row within the plane
     * @return Integer - starting row within the plane
     */
    public Integer getStartingRow() {
        return startingRow;
    }

    /**
     * Setter for Starting Row within the plane
     * @param startingRow - starting row within the plane
     */
    public void setStartingRow(Integer startingRow) {
        this.startingRow = startingRow;
    }

    /**
     * Getter for number of empty seats
     * @return Integer - number of empty seats
     */
    public Integer getEmptySeats() {
        return emptySeats;
    }

    /**
     * Getter for number of total seats
     * @return Integer - number of total seats
     */
    public Integer getTotalSeats() {
        return totalSeats;
    }


    
}
