public class PlasticBag extends Container {
    public PlasticBag(){
        super(State.SOLID, Temperature.COLD);
    }

    public String toString(){
        return "PlasticBag " + super.toString();
    }
}

