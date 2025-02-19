import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ToShare implements Iterable<Product>{
    ProductListIterator produtos = new ProductListIterator(new ArrayList<Product>());
    HashMap<Product, Client> shared = new HashMap<Product, Client>();

    public ToShare(){};

    public boolean add(Product p){
        return produtos.add(p);
    }

    public Product remove(String code){
        Product remover;
        while(produtos.hasNext()){
            Product p = (Product) produtos.next();
            if (p.code().equals(code)){
                remover = p;
                produtos.remove(p);
                return remover;
            }
        }
        return new NullProduct();
    }

    public Product remove(Product produto){
        Product remover;
        while(produtos.hasNext()){
            Product p = (Product) produtos.next();
            if (p.equals(produto)){
                remover = p;
                produtos.remove(p);
                return remover;
            }
        }
        return new NullProduct();
    }

    public boolean share(String code, Client user){
        while(produtos.hasNext()){
            Product p = (Product) produtos.next();
            if(code.equals(p.code())){
                if(p.nextState()){
                    shared.put(p, user);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean share(Product produto, Client user){
        while(produtos.hasNext()){
            Product p = (Product) produtos.next();
            if(p.equals(produto)){
                if(p.nextState()){
                    shared.put(p, user);
                    return true;
                }
            }
        }
        return false; 
    }

    public boolean giveBack(String code){
        for (Product p : shared.keySet()){
            if(code.equals(p.code())){
                if(p.nextState()){
                    shared.remove(p);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean giveBack(Product produto){
        for (Product p : shared.keySet()){
            if(p.equals(produto)){
                if(p.nextState()){
                    shared.remove(p);
                    return true;
                }
            }
        }
        return false;
    }

    public String allAlugados(){
        String res = "";
        for (Product p : shared.keySet()){
            res += "\n" + p;
        }
        return res;
    }

    public String sharedProducts(){
        return allAlugados();
    }

    public ArrayList<Product> getProducts(){
        return produtos.getProductList();
    }

    @Override
    public Iterator<Product> iterator() {
        return new ProductListIterator(produtos.getProductList());
    }
}
