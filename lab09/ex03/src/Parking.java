import java.util.ArrayList;

public class Parking {
    private ArrayList<Employee> employees = new ArrayList<>();

    public Parking() {
    }

    public void allowEmployee(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
