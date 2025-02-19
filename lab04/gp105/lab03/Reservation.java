public class Reservation {
    String flightCode;
    Integer numberOfPeople;
    ClassCategory category;
    ReservationStatus status;
    Integer sequentialReservationNumber;

    /**
     * Constructor for Reservation. Requires a target flight, the number of people, and the desired category. <p> The status of the reservation is initialized at {@code NOTPROCESSED}, and the sequential reservation number is initialized at {@code 0}. <p> <STRONG>Should only be invoked by Reservation Manager</STRONG>
     * @param flight
     * @param numberOfPeople
     * @param category
     */
    Reservation(String flight, Integer numberOfPeople, ClassCategory category){
        this.flightCode = flight;
        this.numberOfPeople = numberOfPeople;
        this.category = category;
        this.status = ReservationStatus.NOTPROCESSED;
        this.sequentialReservationNumber = 0;
    }

    /**
     * Flight code getter.
     * @return flight code
     */
    public String getFlightCode() {
        return this.flightCode;
    }

    /**
     * Number of people getter
     * @return number of people
     */
    public Integer getNumberOfPeople() {
        return this.numberOfPeople;
    }

    /**
     * Category getter
     * @return category
     */
    public ClassCategory getCategory() {
        return this.category;
    }

    /**
     * Status getter
     * @return
     */
    public ReservationStatus getStatus() {
        return this.status;
    }

    /**
     * Flight code setter
     * @param flightCode
     */
    public void setFlight(String flightCode) {
        this.flightCode = flightCode;
    }

    /**
     * Number of people setter
     * @param numberOfPeople
     */
    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    /**
     * Category setter
     * @param category
     */
    public void setCategory(ClassCategory category) {
        this.category = category;
    }

    /**
     * Status setter
     * @param status
     */
    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    /**
     * Sequential Reservation Number (SRN) getter
     * @return SRN
     */
    public Integer getSequentialReservationNumber() {
        return sequentialReservationNumber;
    }

    /**
     * Sequential Reservation Number (SRN) setter
     * @param sequentialReservationNumber
     */
    public void setSequentialReservationNumber(Integer sequentialReservationNumber) {
        this.sequentialReservationNumber = sequentialReservationNumber;
    }
}
