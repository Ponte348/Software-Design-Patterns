import java.util.ArrayList;

public class Leilao {
    ArrayList<Produto> listOfProducts;

    public Leilao(){
        listOfProducts = new ArrayList<>();
    }

    public void addProduct(Produto product){
        listOfProducts.add(product);
    }
}
