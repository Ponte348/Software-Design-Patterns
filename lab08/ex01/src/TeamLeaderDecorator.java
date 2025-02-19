import java.util.Date;

public class TeamLeaderDecorator extends EmployeeDecorator {
    public TeamLeaderDecorator(Employee employee) {
        super(employee);
    }

    /**
     * Makes the employee work with extra team leader responsabilities
     * @return String
     */
    @Override
    public String work() {
        return super.work() + plan();
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
     * Adds the team leader responsabilities
     * @return String
     */
    public String plan() {
        return ", Team Leader";
    }
}
