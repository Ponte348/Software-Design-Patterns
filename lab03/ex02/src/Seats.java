public class Seats {
    private SeatClasses SeatClass;
    private Integer ReservationNumber;

    /**
     * Constructor for Seats
     * @param seatClass - Class of the seat
     * @param reservationNumber - Reservation number
     */
    public Seats(SeatClasses seatClass, Integer reservationNumber) {
        this.SeatClass = seatClass;
        this.ReservationNumber = reservationNumber;
    }

    public SeatClasses getSeatClass() {
        return SeatClass;
    }
    public void setSeatClass(SeatClasses seatClass) {
        this.SeatClass = seatClass;
    }
    public Integer getReservationNumber() {
        return ReservationNumber;
    }
    public void setReservationNumber(Integer reservationNumber) {
        this.ReservationNumber = reservationNumber;
    }
}
