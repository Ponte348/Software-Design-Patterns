public class ThermicBottle extends Container {
    public ThermicBottle(){
        super(State.LIQUID, Temperature.WARM);
    }

    public String toString(){
        return "ThermicBottle " + super.toString();
    }
}

