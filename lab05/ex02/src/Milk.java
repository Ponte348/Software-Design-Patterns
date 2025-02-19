public class Milk extends Food{
    Milk(){
        super(State.LIQUID, Temperature.WARM);
    }

    public String toString(){
        return "Milk: " + super.toString();
    }
}
