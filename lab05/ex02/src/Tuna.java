public class Tuna extends Food{
    public Tuna(){
        super(State.SOLID, Temperature.COLD);
    }

    public String toString(){
        return "Tuna: " + super.toString();
    }
}
