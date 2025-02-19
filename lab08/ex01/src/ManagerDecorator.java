import java.util.Date;

public class ManagerDecorator extends EmployeeDecorator {
    public ManagerDecorator(Employee employee) {
        super(employee);
    }

    /**
     * Makes the employee work with extra manager responsabilities
     */
    @Override
    public String work() {
        return super.work() + manage();
    }

    /**
     * Set the start date of the employee
     * @param date
     */
    @Override
    public void start(Date date) {
        super.start(date);
    }

    /**
     * Set the end date of the employee
     * @param date
     */
    @Override
    public void terminate(Date date) {
        super.terminate(date);
    }

    /**
     * Adds the manager responsabilities
     * @return String
     */
    public String manage() {
        return ", Manager";
    }
}
