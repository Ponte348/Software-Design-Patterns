public class PlasticBottle extends Container {
    public PlasticBottle(){
        super(State.LIQUID, Temperature.COLD);
    }

    public String toString(){
        return "PlasticBottle " + super.toString();
    }
}
