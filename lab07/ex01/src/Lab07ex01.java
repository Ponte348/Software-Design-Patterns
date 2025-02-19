public class Lab07ex01 {
    public static void main(String[] args) {

        //create the Sweets company with some employees
        Database sweets = new Database();
        Employee employee1 = new Employee("Jose Pinto", 1, 800);
        Employee employee2 = new Employee("Ana Paulo", 2, 950);

        sweets.addEmployee(employee1);
        sweets.addEmployee(employee2);

        //create Petiscos company with some employees
        Registos petiscos = new Registos();
        Empregado emepregado1 = new Empregado("Manuel", "Maria", 3, 1000);
        Empregado emepregado2 = new Empregado("Maria", "Manuel", 4, 1150);

        petiscos.insere(emepregado1);
        petiscos.insere(emepregado2);

        //merge the two companies into PetiscosESweets(pst)

        Adapter pst = new Adapter(petiscos);

        pst.addDatabase(sweets);

        Empregado emepregado3 = new Empregado("Jorge", "Oliveira", 5, 1500);
        Employee employee3 = new Employee("Fernando Maia", 6, 975);

        pst.addEmployee(emepregado3);
        pst.addEmployee(employee3);

        pst.printEmployees();

        System.out.print("Jose Pinto é empregado? ");
        if(pst.employeeExists(1)){
            System.out.println("Sim");
        }else{
            System.out.println("Não");
        }

        System.out.print("Joao Jose é empregado? ");
        if(pst.employeeExists(70)){
            System.out.println("Sim");
        }else{
            System.out.println("Não");
        }
        }
    
}
