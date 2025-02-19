package Ex2;
import java.util.ArrayList;

public class GerenciadorVoos {
    ArrayList<Voo> voos;

     /** 
    * Construtor da classe GerenciadorVoos
    */ 
    public GerenciadorVoos() {
        voos = new ArrayList<Voo>();
    }

     /** 
    * Adiciona um voo ao gerenciador
    */ 
    public void addVoo(Voo voo) {
        voos.add(voo);
    }

    /**
     * Retorna um voo a partir do seu código
     */
    public Voo getVoo(String code) {
        for (Voo voo : voos) {
            if (voo.getCode().equals(code)) {
                return voo;
            }
        }
        System.out.println("Flight does not exist");
        return null;
    }


    /**
    * Cancela lugares em um voo
    */
    public void cancelReservation(int reservationNumber, String code){
        Voo voo = getVoo(code);
        ArrayList<String> cancelledSeats =  new ArrayList<String>();
        if (voo == null) {
            System.out.println("Flight does not exist");
            return;
        }
        Plane plane = voo.getPlane();
        if (plane.hasExecutive()) {
            int[][] executiveSeats = plane.getExecutiveSeats();
            for (int i = 0; i < executiveSeats[0].length; i++) {
                for (int j = 0; j < executiveSeats.length; j++) {
                    if (executiveSeats[j][i] == reservationNumber) {
                        plane.setExecutiveSeats(j, i, 0);
                        cancelledSeats.add(plane.getSeat(j, i, 'E'));
                    }
                }
            }
        }
        int[][] touristSeats = plane.getTouristicSeats();
        for (int i = 0; i < touristSeats[0].length; i++) {
            for (int j = 0; j < touristSeats.length; j++) {
                if (touristSeats[j][i] == reservationNumber) {
                    plane.setTouristicSeats(j, i, 0);
                    cancelledSeats.add(plane.getSeat(j, i, 'T'));
                }
            }
        }
        if (cancelledSeats.size() == 0) {
            System.out.println("Reservation does not exist");
        }
        else {
            System.out.println("Reservation" + reservationNumber+  "cancelled -> " + cancelledSeats);
        }
    }

    
}
