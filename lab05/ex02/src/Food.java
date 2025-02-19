public abstract class Food implements Portion {
    private State estado;
    private Temperature temperatura;

    Food(State estado, Temperature temperatura){
        this.estado = estado;
        this.temperatura = temperatura;
    }

    @Override
    public State getState() {
        return estado;
    }
    @Override
    public Temperature getTemperature() {
        return temperatura;
    }

    public String toString(){
        return "Temperature " + temperatura + ", State " + estado;
    }

}
