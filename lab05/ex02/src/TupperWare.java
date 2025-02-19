public class TupperWare extends Container {
    public TupperWare(){
        super(State.SOLID, Temperature.WARM);
    }

    public String toString(){
        return "TupperWare " + super.toString();
    }
}
