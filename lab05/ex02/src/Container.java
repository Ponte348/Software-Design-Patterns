public abstract class Container {
    private State estado;
    private Temperature temperatura;
    private Portion portion;

    Container(State estado, Temperature temperatura){
        this.estado = estado;
        this.temperatura = temperatura;
    }

    public static Container create (Portion portion){
        Container container;
        if(portion.getState() == State.SOLID){
            if(portion.getTemperature() == Temperature.COLD){
                container = new PlasticBag();
            }else{
                container = new TupperWare();
            }
        }else if(portion.getState() == State.LIQUID){
            if(portion.getTemperature() == Temperature.COLD){
                container = new PlasticBottle();
            }else{
                container = new ThermicBottle();
            }
        }
        else{
            throw new IllegalArgumentException("Invalid portion state");
        }

        container.setPortion(portion);
        return container;
    }

    public State getState() {
        return estado;
    }

    public Temperature getTemperature() {
        return temperatura;
    }

    public void setPortion(Portion p){
        portion = p;
    }

    public String toString(){
        return String.format("with portion = %s", portion);
    }

    
}
