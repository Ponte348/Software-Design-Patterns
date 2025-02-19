import java.util.ArrayList;

public class SocialSecurity {
    private ArrayList<Employee> employees = new ArrayList<>();

    public SocialSecurity() {
    }

    public void registerEmployee(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
