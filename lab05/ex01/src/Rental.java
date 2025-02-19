import java.util.*;
public class Rental {
    //list of all vehicles available
    private List <Veiculo> stock = new ArrayList <Veiculo> ();
    private String name;
    private String number;
    private String email; 

    public Rental(String name, String number, String email){
        this.name = name;
        this.number = number;
        this.email = email;
    }
    public Rental(){
        this("Sem nome", "Sem número", "Sem email");
    }

    //add vehicle to stock
    public void addVeiculo(Veiculo veiculo){
        this.stock.add(veiculo);
    }

    //return the vehicle stock
    public List<Veiculo> getStock(){
        return this.stock;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public String getNumber(){
        return this.number;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String geEmail(){
        return this.email;
    }
}




