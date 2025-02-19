import java.util.ArrayList;
import java.util.List;

class Registos { 
    // Data elements 
    private ArrayList<Empregado> empregados; // Stores the employees 
    public Registos() { 
     empregados = new ArrayList<>(); 
    } 

    public void insere(Empregado emp) { 
     // Code to insert employee 
        empregados.add(emp);
    } 

    public void remove(int codigo) { 
     // Code to remove employee 
        for(int i=0; i<empregados.size(); i++){
            if(empregados.get(i).codigo() == codigo){
                empregados.remove(i);
            }
        }
    } 

    public boolean isEmpregado(int codigo) { 
     // Code to find employee 
        boolean checkEmpregado = false;
        for(int i=0; i<empregados.size(); i++){
            if(empregados.get(i).codigo()==codigo){
                return checkEmpregado = true;
            }
        }
        return checkEmpregado;
    } 
    
    public List<Empregado> listaDeEmpregados() { 
     // Code to retrieve collection
        ArrayList<Empregado> empregadoList = new ArrayList<>();
        
        for(int i=0; i<empregados.size(); i++){
            empregadoList.add(empregados.get(i));
        }

        return empregadoList;
    } 
    
}
