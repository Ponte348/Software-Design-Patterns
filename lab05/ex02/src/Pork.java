public class Pork extends Food{
    public Pork(){
        super(State.SOLID, Temperature.WARM);
    }

    public String toString(){
        return "Pork: " + super.toString();
    }
}
