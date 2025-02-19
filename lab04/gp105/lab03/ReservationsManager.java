import java.util.ArrayList;

public class ReservationsManager {
    private ArrayList<Reservation> allReservations;

    /**
     * Reservations Manager constructor. Initializes Reservation Array.
     */
    public ReservationsManager(){
        this.allReservations = new ArrayList<Reservation>();
    }

    /**
     * Searches for all reservations that are relative to a particular flight.
     * @param code
     * @return Array List with all the reservations for the flight in question
     */
    public ArrayList<Reservation> getReservationsForFlight(String code){
        ArrayList<Reservation> reservationsForFlight = new ArrayList<Reservation>();
        for (Reservation reservation : allReservations){
            if (reservation.getFlightCode().equals(code)) reservationsForFlight.add(reservation);
        }
        return reservationsForFlight;
    }

    /**
     * Given a flight code and a sequential number, returns the reservation in question.
     * @param code
     * @param reservantionNumber
     * @return Reservation
     */
    public Reservation getRerservationForFlight(String code, int reservantionNumber){
        ArrayList<Reservation> reservationsForFlight = getReservationsForFlight(code);
        for (Reservation reservation : reservationsForFlight){
            if (reservation.getSequentialReservationNumber()==reservantionNumber){
                return reservation;
            }
        }
        return null;
    }

    /**
     * Returns all reservations made in all flights.
     * @return All reservations
     */
    public ArrayList<Reservation> getAllReservations() {
        return allReservations;
    }

    /**
     * Creates new reservation. ReservationsManager is responsible for creating a new reservation and adding it to its list. <p> Requires a target flight, the number of people, and the desired category. <p> The status of the reservation is initialized at {@code NOTPROCESSED}, and the sequential reservation number is initialized at {@code 0}.
     * @param flightCode
     * @param numberOfPeople
     * @param category
     * @return newly created Reservation
     */
    public Reservation createNewReservation(String flightCode, Integer numberOfPeople, ClassCategory category){
        Reservation reservation = new Reservation(flightCode, numberOfPeople, category);
        this.allReservations.add(reservation);
        return reservation;
    }
}
