import java.util.HashMap;
import java.util.ArrayList;

public class FlightManager {
    private HashMap<String, Flight> allFlights;

    /**
     * Flight Manager constructor. Initializes new HashMap which contains all the flights, associated with their code.
     */
    FlightManager(){
        this.allFlights = new HashMap<String, Flight>();
    }

    /**
     * Returns the Flight correspondant to the code. Returns null if there is no such flight.
     * @param code
     * @return correspondant flight or {@code null} if there is none
     */
    public Flight getFlightFromCode(String code){
        return this.allFlights.get(code);
    }

    /**
     * Adds a flight to the HashMap.
     * @param flight
     */
    public void addFlight(Flight flight){
        this.allFlights.put(flight.getCode() ,flight);
    }

    /**
     * Creates new reservation. ReservationsManager is responsible for creating a new reservation and adding it to its list. <p> Requires info for each class and seats. Allows for how many classes you want. <p> Also requires flight code.
     * @param seatsInfo
     * @param classesInfo
     * @param code
     * @return newly created Flight
     */
    public Flight createNewFlight(ArrayList<Integer[]> seatsInfo, ArrayList<String> classesInfo, String code){
        Flight flight = new Flight(seatsInfo, classesInfo, code);
        addFlight(flight);
        return flight;
    }

    /**
     * Attempts to reserve seats in the flight. Returns a boolean dependant on success.
     * @param reservation
     * @return {@code true} if successful. {@code false} otherwise
     */
    public boolean attemptReservation(Reservation reservation){
        Flight targetFlight = getFlightFromCode(reservation.getFlightCode());
        if (targetFlight == null) return false;
        if (targetFlight.attemptReservation(reservation)) return true;
        return false;
    }

    /**
     * Returns the list of seats occupied by a certain reservation.
     * @param reservation
     * @return Array List with all the seats occupied by a certain reservation
     */
    public ArrayList<Integer[]> getSeatsInPlaneByID(Reservation reservation){
        Flight targetFlight = this.getFlightFromCode(reservation.getFlightCode());
        return targetFlight.getSeatsByID(reservation.getSequentialReservationNumber());
    }
}
