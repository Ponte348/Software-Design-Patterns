package Ex2;

public class Voo {
    private final String code;
    private final Plane plane;
    private int reservas = 0;

    public Voo(Plane plane, String code ) {
        this.plane = plane;
        this.code = code;
        reservas = 1;
    }
    
     /** 
    * Retorna o código do voo
    */ 
    public String getCode(){
        return code;
    }

    /**
     * Retorna o avião associado ao voo
     */
    public Plane getPlane() {
        return plane;
    }


     /** 
    * Mostra o mapa de lugares do voo
    */ 
    public void show_bookingmap(){
        int[][] EXECUTIVE_FILAS=this.plane.getExecutiveSeats();

        if (EXECUTIVE_FILAS == null) {
            int[][] TOURISTIC_FILAS=this.plane.getTouristicSeats(); 
            int numFilasTouristicas=TOURISTIC_FILAS[0].length;         //FILAS 
            int LugaresFilaTouristicas=TOURISTIC_FILAS.length;         //COLUNAS
            for (int i = 1; i <= numFilasTouristicas; i++) {
                System.out.printf("%3d, ", i);
            }
            System.out.println();
            for( int lugar =0; lugar < LugaresFilaTouristicas ; lugar++){
                System.out.print((char)(lugar+65));
                for (int fila = 0; fila < numFilasTouristicas; fila++) {
                    System.out.printf("%3d", TOURISTIC_FILAS[lugar][fila]);
                }
                System.out.println();
            }
            return;
        }
        
        int numFilasExecutivas=EXECUTIVE_FILAS[0].length;         //NUMEROFILAS executivas
        int LugaresFilaExecutivas=EXECUTIVE_FILAS.length;         //LUGARES  executivas

        int[][] TOURISTIC_FILAS=this.plane.getTouristicSeats(); 
        int numFilasTouristicas=TOURISTIC_FILAS[0].length;         //NUMEROFILAS TOURIRSTICA
        int LugaresFilaTouristicas=TOURISTIC_FILAS.length;         //NUMEROFILAS TOURISTICA
        int MAX_FILAS=0;
        int MAX_LUGAR=0; 
        boolean EXECUTIVE = false;
        System.out.println(numFilasExecutivas + " " + LugaresFilaExecutivas + " " + numFilasTouristicas + " " + LugaresFilaTouristicas); 
        
        if(numFilasExecutivas == 0 || LugaresFilaExecutivas == 0 ){
            MAX_FILAS = numFilasTouristicas-1;
            MAX_LUGAR= LugaresFilaTouristicas;
        }else{
            MAX_FILAS= numFilasExecutivas + numFilasTouristicas-1;
            MAX_LUGAR= Math.max(LugaresFilaExecutivas, LugaresFilaTouristicas);
            System.out.println(MAX_FILAS);
            EXECUTIVE = true;
        }

        for (int i = 1; i <= MAX_FILAS; i++) {
            System.out.print("\t" + i);
        }
        System.out.println();
        for( int lugar =0; lugar < MAX_LUGAR ; lugar++){
            System.out.print((char)(lugar+65));
            for (int fila = 0; fila < MAX_FILAS; fila++) {
                if (EXECUTIVE) {
                    if (fila < numFilasExecutivas) {
                        if (lugar >= LugaresFilaExecutivas) System.out.print("\t");
                        else System.out.print("\t" + EXECUTIVE_FILAS[lugar][fila]);
                    } else {
                        if (lugar >= LugaresFilaTouristicas) System.out.print("\t");
                        else System.out.print("\t" + TOURISTIC_FILAS[lugar][fila - numFilasExecutivas]);
                    }
                } else {
                    if (fila < LugaresFilaTouristicas) {
                        System.out.print("\t" + TOURISTIC_FILAS[lugar][fila]);
                    }
                }
            }
            System.out.println();
        }
    }

    /** 
    * Reserva lugares no voo
    */ 
    public String[] ReserveSeats(char classe, int seats){
        int lugaresAtribuidos = 0;
        String[] seatsReserved = new String[seats];

        if  (classe == 'T') {
            if (seats > plane.getTotalCapacityTouristic() - plane.getOccupiedTouristic()){
                System.out.println("Não foi possível obter lugares para a reserva: " + classe + " " + seats + ";" );
                return null;
            }
            else {
                for (int i = 0; i < plane.getTouristicSeats()[0].length; i++){
                    int lugaresFilaLivres = 0;
                    for (int j = 0; j < plane.getTouristicSeats().length; j++){
                        if (plane.getTouristicSeats()[j][i] == 0){
                            lugaresFilaLivres++;
                        }
                        if (lugaresFilaLivres == seats){
                            for (int k = 0; k < seats; k++){
                                plane.setTouristicSeats(j-k, i, reservas);
                                seatsReserved[k] = plane.getSeat(j-k, i, 'T');
                                lugaresAtribuidos++;
                            }
                            reservas++;
                            return seatsReserved;
                        }
                    }
                }
                for (int i = 0; i < plane.getTouristicSeats()[0].length; i++){
                    for (int j = 0; j < plane.getTouristicSeats().length; j++){
                        if (plane.getTouristicSeats()[j][i] == 0){
                            plane.setTouristicSeats(j, i, reservas);
                            seatsReserved[lugaresAtribuidos] = plane.getSeat(j, i, 'T');
                            lugaresAtribuidos++;
                            if (lugaresAtribuidos == seats){
                                reservas++;
                                return seatsReserved;
                            }
                        }
                    }
                }
            }
        }
        else if (classe == 'E'){
            if (seats > plane.getTotalCapacityExecutive() - plane.getOccupiedExecutive()){ //não há lugares suficientes
                System.out.println("Não foi possível obter lugares para a reserva: " + classe + " " + seats + ";" );
                return null;
            }
            else {
                for (int i = 0; i < plane.getExecutiveSeats()[0].length; i++){
                    int lugaresFilaLivres = 0;
                    for (int j = 0; j < plane.getExecutiveSeats().length; j++){
                        if (plane.getExecutiveSeats()[j][i] == 0){
                            lugaresFilaLivres++;
                        }
                        if (lugaresFilaLivres == seats){
                            for (int k = 0; k < seats; k++){
                                plane.setExecutiveSeats(j-k, i, reservas);
                                seatsReserved[k] = plane.getSeat(j-k, i, 'E');
                                lugaresAtribuidos++;
                            }
                            reservas++;
                            return seatsReserved;
                        }
                    }
                }
                for (int i = 0; i < plane.getExecutiveSeats()[0].length; i++){
                    for (int j = 0; j < plane.getExecutiveSeats().length; j++){
                        if (plane.getExecutiveSeats()[j][i] == 0){
                            plane.setExecutiveSeats(j, i, reservas);
                            seatsReserved[lugaresAtribuidos] = plane.getSeat(j, i, 'E');
                            lugaresAtribuidos++;
                            if (lugaresAtribuidos == seats){
                                reservas++;
                                return seatsReserved;
                            }
                        }
                    }
                }
            }
        }
        return seatsReserved;
    }

    /**
     * Imprime os lugares que foram reservados
    */
    public void printSeats(String[] seatsReserved, String code){
        System.out.print(code + ":" + seatsReserved.length + " = ");
        for (int i = 0; i < seatsReserved.length; i++){
            System.out.print(seatsReserved[i] + " | ");
        }
    }

    @Override
    public String toString() {
        if (plane.hasExecutive()){
            return "Código de voo = " + code  + "; Lugares disponíveis: " + plane.getTotalCapacityExecutive() + " lugares em classe Executiva; " + plane.getTotalCapacityTouristic() + " lugares em classe Turística.";
        }
        else {
            return "Código de voo = " + code  + "; Lugares disponíveis: " + plane.getTotalCapacityTouristic() + " lugares em classe Turística.";
        }
    }

}
