import java.util.ArrayList;

public class Plane {
    private final int NROWS = 0;
    private final int SEATSPERROW = 1;

    ArrayList<AirplaneClass> allClasses;
    private int reservationsMade;


    /**
     * Plane constructor. Requires info for each class and seats. Allows for how many classes you want. <p> <STRONG>Should only be invoked by Flight</STRONG>
     * @param seatsInfo - info on the seats. Array List with Integer[] with structure: [row, seatsPerRow]
     * @param classesInfo - info on the classes. 
     */
    public Plane(ArrayList<Integer[]> seatsInfo, ArrayList<String> classesInfo){
        allClasses = new ArrayList<AirplaneClass>();
        for (int eachClass = 0; eachClass < seatsInfo.size(); eachClass++){
            ClassCategory currentCategory = ClassCategory.getClassFromLetter(classesInfo.get(eachClass));
            int currentNrRows = getTotalRows();
            AirplaneClass newClass = new AirplaneClass(currentCategory, seatsInfo.get(eachClass)[NROWS], seatsInfo.get(eachClass)[SEATSPERROW], currentNrRows+1);
            int idx = (ClassCategory.getClassOrder(currentCategory) < allClasses.size()) ? ClassCategory.getClassOrder(currentCategory) : allClasses.size();
            allClasses.add(idx, newClass);
        }
        this.reservationsMade = 1;
    }

    /**
     * Given a class category (Turistic, Executive, etc) returns the class associated with it.
     * @param category
     * @return AirplaneClass respective to the category
     */
    public AirplaneClass getClassByCategory(ClassCategory category){
        for (AirplaneClass eachClass : allClasses){
            if (eachClass.description == category) return eachClass;
        }
        return null;
    }

    /**
     * Attempts to make a new reservation. Updates the reservation status whether it is accepted or rejected
     * @param reservation - reservation data
     * @return {@code true} if reservation was successful, {@code false} otherwise
     */
    public boolean newReservation(Reservation reservation){
        AirplaneClass airplaneClass = getClassByCategory(reservation.getCategory());
        if (airplaneClass == null) return false;
        if (airplaneClass.newReservation(reservation.getNumberOfPeople(), this.reservationsMade)) {
            reservation.setSequentialReservationNumber(this.reservationsMade++); 
            reservation.setStatus(ReservationStatus.ACCEPTED);
            return true;
        }
        reservation.setStatus(ReservationStatus.REJECTED);
        return false;
    }

    /**
     * Cancels a reservation. Updates the status of the reservation to cancelled.
     * @param reservation - reservation data
     */
    public void cancelReservations(Reservation reservation) {
        int OwnerID = reservation.getSequentialReservationNumber();
        for (int category = 0; category < allClasses.size(); category++){
            allClasses.get(category).deallocateSeats(OwnerID);
            reservation.setStatus(ReservationStatus.CANCELLED);
        }
    }

    /**
     * gets the seats that the sequential number has occupied in the plane. Always returns an Array List, even if null
     * @param ID - sequential number given to reservation
     * @return Array List with all seats occupied by the sequential number
     */
    public ArrayList<Integer[]> getSeatsByID(int ID){
        ArrayList<Integer[]> seats = new ArrayList<Integer[]>();
        for (AirplaneClass airplaneClass : allClasses){
            seats = airplaneClass.getSeatsByID(ID);
            if (seats.size() != 0){
                break;
            }
        }
        return seats;
    }

    /**
     * Returns the total capacity of the airplane (within every class)
     * @return total capacity of the plane
     */
    public Integer getTotalCapacity(){
        int res = 0;
        for (AirplaneClass currentCategory : this.allClasses){
            res += currentCategory.getTotalSeats();
        }
        return res;
    }

    /**
     * returns the number of reservations made in this plane so far (sequential number)
     * @return number of reservations made
     */
    public int getReservationsMade() {
        return reservationsMade;
    }

    /**
     * returns the number of rows within the whole plane
     * @return number of rows in the plane
     */
    public Integer getTotalRows(){
        int res = 0;
        for (AirplaneClass currentCategory : this.allClasses){
            res += currentCategory.getRows();
        }
        return res;
    }

    /**
     * returns the highest amount of seats per row that the plane has
     * @return highest amount of seats per row
     */
    public Integer getMaxSeatsPerRow(){
        int res = 0;
        for (AirplaneClass currentCategory : this.allClasses){
            res = (res > currentCategory.getSeatsInRow()) ? res : currentCategory.getSeatsInRow();
        }
        return res;
    }

    /**
     * Auxiliary function. Converts a number to its ASCII code.
     * @param number - number to be converted
     * @return String correspondant to the ASCII code.
     * <li>
     * Note: if ASCII code goes above Z, it will loop around at AA, AB, ..., BA, etc.
     */
    public String rowToString(int number){
        String res = "";
        int aux_number = number;
        while (number >= 0){
            aux_number = number % 26;
            res = Character.toString((aux_number + 65)) + res;
            number = (number / 26) - 1;
        }
        return res;
    }

    /**
     * Auxiliary function. Returns the Class in which the given row belongs to.
     * @param row - row within the airplane
     * @return AirplaneClass in which the row belongs
     */
    public AirplaneClass selectClassByRow(int row){
        for (AirplaneClass currentClass : allClasses) {
            if (row < currentClass.getStartingRow() + currentClass.getRows() - 1) return currentClass;
        }
        return null;
    }

    /**
     * returns a map that shows the airplane.
     * @return String with the airplane's layout.
     */
    public String toString(){
        String res = "";
        int totalColumns = getTotalRows();
        int totalRows = getMaxSeatsPerRow();
        res += " ";
        for (int currentColumn = 0; currentColumn < totalColumns; currentColumn++){
            res += String.format(" %2s", Integer.toString(currentColumn + 1));
        }
        for (int currentRow = 0; currentRow < totalRows; currentRow++){
            res += "\n"+rowToString(currentRow);
            for (int currentColumn = 0; currentColumn < totalColumns; currentColumn++){
                res += " ";
                AirplaneClass currentClass = selectClassByRow(currentColumn);
                if (currentRow >= currentClass.getSeatsInRow()){
                    res += String.format("%2s", " ");
                }
                else {
                    res += String.format("%2s", Integer.toString(currentClass.seatOwner(currentColumn - currentClass.startingRow + 1, currentRow)));
                }
                
            }
        }
        return res;
    }


}