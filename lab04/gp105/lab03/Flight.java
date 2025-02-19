import java.util.ArrayList;

public class Flight {
    private Plane plane;
    private String code;
    
    /**
     * Constructor for Flight. Requires seat info and flight code. <p> <STRONG> Should only be invoked by Flight Manager </STRONG>
     * @param seatsInfo
     * @param classesInfo
     * @param code
     */
    public Flight(ArrayList<Integer[]> seatsInfo, ArrayList<String> classesInfo, String code) {
        this.plane = new Plane(seatsInfo, classesInfo);
        this.code = code;
    }

    /**
     * Getter for Plane
     * @return Plane associated with Flight
     */
    public Plane getPlane() {
        return plane;
    }

    /**
     * Setter for Plane
     * @param plane
     */
    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    /**
     * Getter for Flight code
     * @return flight code
     */
    public String getCode() {
        return code;
    }
    
    /**
     * Setter for Flight code
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Given a reservation, attempts to allocate seats in the plane. Returns a boolean relative to success.
     * @param reservation
     * @return {@code true} if successful. {@code false} otherwise.
     */
    public boolean attemptReservation(Reservation reservation){
        return this.plane.newReservation(reservation);
    }

    /**
     * Given an ID (or Sequential Number) returns all the seats reserved with that number in the plane.
     * @param ID
     * @return List of all seats occupied with ID.
     */
    public ArrayList<Integer[]> getSeatsByID(int ID){
        return this.plane.getSeatsByID(ID);
    }

    /**
     * Returns flight code and description of available seats for each class.
     */
    public String toString(){
        String res = "Código de voo " + this.getCode() + ". Lugares disponíveis: ";
        boolean first = true;
        for (ClassCategory category : ClassCategory.values()){
            AirplaneClass airplaneClass = this.getPlane().getClassByCategory(category);
            if (airplaneClass != null) {
                if (!first) res += "; ";
                first = false;
                res += airplaneClass.getTotalSeats() + " lugares em classe " + ClassCategory.getToString(category);
            }
        }
        res += ".\n"; 
        String aux_res = res;
        first = true;
        for (ClassCategory category : ClassCategory.values()){
            AirplaneClass airplaneClass = this.getPlane().getClassByCategory(category);
            if (airplaneClass == null) {
                if (!first) res += "; ";
                first = false;
                res += "Classe " + ClassCategory.getToString(category).toLowerCase() + " não disponível neste voo.";
            }
        }
        res += (aux_res.equals(res)) ? "" : "\n"; 
        return res;
    }


}
