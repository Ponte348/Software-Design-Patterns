import java.util.ArrayList;
import java.util.Iterator;

public class ProductListIterator implements Iterator<Product>{
    private ArrayList<Product> productList = new ArrayList<>();
    private int index;
    
    public ProductListIterator(ArrayList<Product> products){
        productList = products;
        index = 0;
    }
    
    public boolean add(Product p){
        return productList.add(p);
    }
    
    public boolean remove(Product p){
        return productList.remove(p);
    }
    
    @Override
    public boolean hasNext() {
        return index < productList.size();
    }
    
    @Override
    public Product next() {
        return productList.get(index++);
    }
    
    public ArrayList<Product> getProductList() {
        return productList;
    }
    
}
