public class NullProduct implements Product{
    public NullProduct(){
    }

    @Override
    public String code() {
        return "No code";
    }
    @Override
    public String description() {
        return "No description";
    }
    @Override
    public double points() {
        return 0.0;
    }

    @Override
    public String toString(){
        return "Invalid Product";
    }

    @Override
    public void setState(ProductState estado) {
    }

    @Override
    public boolean nextState() {
        return false;
    }

    @Override
    public boolean equals(Product p) {
        return false;
    }
}