public class Adapter {
    private Registos toAdapt;

    public Adapter(Registos toAdapt){
        this.toAdapt = toAdapt;
    }

    public void addDatabase(Database database){
        for(Employee employee : database.getAllEmployees()){
            toAdapt.insere(adaptEmployee(employee));
        }
    }

    private Empregado adaptEmployee(Employee employee){
        return new Empregado(employee.getName().split(" ")[0], employee.getName().split(" ")[1], (int) employee.getEmpNum(), employee.getSalary());
    }

    public void addEmployee(Empregado empregado){
        toAdapt.insere(empregado);
    }

    public void addEmployee(Employee employee){
        addEmployee(adaptEmployee(employee));
    }

    public void removeEmployee(long empNumber){
        toAdapt.remove((int) empNumber);
    }

    public boolean employeeExists(long empNumber){
        return toAdapt.isEmpregado((int) empNumber);
    }

    public void printEmployees(){
        for(Empregado empregado : toAdapt.listaDeEmpregados()){
            System.out.printf("Name: %s %s || Number: %d || Salary: %.2f\n", empregado.nome(), empregado.apelido(), empregado.codigo(), empregado.salario());
        }
    }
}
