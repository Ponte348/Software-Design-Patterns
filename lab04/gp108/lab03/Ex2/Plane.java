package Ex2;


public class Plane {
    private int[][] TouristSeats;
    private int[][] ExecutiveSeats;
    boolean hasExecutive;

    /*
    * Construtor da classe Plane
    */
    public Plane(int numFilasTouristas, int lugaresFilaTourista, int numFilasExecutivas, int lugaresFilaExecutiva) {
        this.TouristSeats = new int[lugaresFilaTourista][numFilasTouristas];
        this.ExecutiveSeats = new int[lugaresFilaExecutiva][numFilasExecutivas];
        hasExecutive = true;
    }
    /* 
    * Construtor da classe Plane com a indicação do numero de filas e colunas da classe turista
    */
    public Plane(int numFilasTouristas, int lugaresFilaTourista) {
        this.TouristSeats = new int[lugaresFilaTourista][numFilasTouristas];
        hasExecutive = false;
    }

    /*
    * Retorna os lugares turisticos
    */
    public int[][] getTouristicSeats() {
        return TouristSeats;
    }

    /*
    * Atribui os lugares turisticos ao numero de reserva
    */
    public void setTouristicSeats(int i, int j, int reservationNumber){
        TouristSeats[i][j] = reservationNumber;
    }

    /*
    * Retorna os lugares Executivos
    */
    public int[][] getExecutiveSeats() {
        if (hasExecutive == false) {
            return null;
        }
        return ExecutiveSeats;
    }

    /*
    * Atribui os lugares Executivos ao numero de reserva
    */
    public void setExecutiveSeats(int i, int j, int reservationNumber){
        ExecutiveSeats[i][j] = reservationNumber;
    }

    /*
    * Retorna o numero total de lugares turisticos
    */
    public int getTotalCapacityTouristic(){
        return TouristSeats.length * TouristSeats[0].length;
    }

    /*
    * Retorna o numero total de lugares executivos
    */
    public int getTotalCapacityExecutive(){
        if(ExecutiveSeats.length == 0 ){  
            return 0;
        }
        return ExecutiveSeats.length * ExecutiveSeats[1].length;
    }

    /*
    * Retorna o numero de lugares ocupados na classe executiva
    */
     public int getOccupiedExecutive(){
        int OccupiedSeats = 0;

        for( int i = 0; i < ExecutiveSeats.length; i++){
            for ( int j = 0; j < ExecutiveSeats[0].length; j++){
                if( ExecutiveSeats[i][j] != 0){
                     OccupiedSeats = OccupiedSeats + 1;
                }
            }
        }
        return OccupiedSeats;
     }

    /*
    * Retorna o numero de lugares ocupados na classe turistica
    */
     public int getOccupiedTouristic(){
        int OccupiedSeats = 0;

        for( int i = 0; i < TouristSeats.length; i++){
            for ( int j = 0; j < TouristSeats[0].length; j++){
                if( TouristSeats[i][j] != 0){
                    OccupiedSeats = OccupiedSeats + 1;
                }
            }
        }
        return OccupiedSeats;
     }

    /*
    * Retorna se o avião tem classe executiva
    */
    public boolean hasExecutive(){
        return hasExecutive;
    }

    /*
    * Retorna o lugar do avião
    */
    public String getSeat(int row, int column, char classe){
        if (row < 0 || row >= TouristSeats.length || column < 0 || column >= TouristSeats[0].length){
            return "Invalid seat";
        }
        char rowLetter = (char)(row + 65);

        if (classe == 'E') {
            return rowLetter + Integer.toString(column+1);
        }
        else if (classe == 'T' && hasExecutive == true) {
            return rowLetter + Integer.toString(column+1+ExecutiveSeats[0].length);
        }
        else {
            return rowLetter + Integer.toString(column+1);
        }
    }

    /*
    * Retorna a representação em string do avião
    */
    @Override
    public String toString() {
        return "Plane: \n" + "TouristiSeats Number=" + this.getTotalCapacityTouristic() + "\n" + 
                             "ExecutiveSeats Number=" + this.getTotalCapacityTouristic() + "\n" + 
                             "OccupiedExecutiveSeats Number=" + this.getOccupiedExecutive() + "\n" + 
                             "OccupiedTouristicSeats Number=" + this.getOccupiedTouristic() + "\n" + ";";
    }



}
