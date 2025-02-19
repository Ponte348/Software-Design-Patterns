public class AvailableState implements ProductState{
    @Override
    public void nextState(Product produto) {
        produto.setState(new SharedState());
    }

    public String toString(){
        return "AvailableState";
    }
}
