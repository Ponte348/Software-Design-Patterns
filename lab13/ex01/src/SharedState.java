public class SharedState implements ProductState{
    @Override
    public void nextState(Product produto) {
        produto.setState(new AvailableState());
    }

    public String toString(){
        return "AvailableState";
    }
}