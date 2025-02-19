import java.util.ArrayList;

public class Insurance {
    private ArrayList<Employee> employees = new ArrayList<>();

    public Insurance() {
    }

    public void regist(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
