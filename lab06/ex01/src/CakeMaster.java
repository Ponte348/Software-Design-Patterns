public class CakeMaster {
    private CakeBuilder cakeBuilder;
    private Cake cake;

    CakeMaster(){
        cakeBuilder = null;
        cake = null;
    }

    public void setCakeBuilder(CakeBuilder cakeBuilder) {
        this.cakeBuilder = cakeBuilder;
    }


    public void createCake(String message) {
        cakeBuilder.createCake();
        cake = cakeBuilder.getCake();
    }

    public void createCake(Shape shape, int numCakeLayers, String message) {
        cakeBuilder.createCake();
        cake = cakeBuilder.getCake();
    }

    public void createCake(int numCakeLayers, String message) {
        cakeBuilder.createCake();
        cake = cakeBuilder.getCake();
    }

    public Cake getCake() {
        return cake;
    }
}
