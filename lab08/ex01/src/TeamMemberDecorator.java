import java.util.Date;

public class TeamMemberDecorator extends EmployeeDecorator {
    public TeamMemberDecorator(Employee employee) {
        super(employee);
    }

    /**
     * Makes the employee work with extra team member responsabilities
     * @return String
     */
    @Override
    public String work() {
        return super.work() + collaborate();
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
     * Adds the team member responsabilities
     * @return String
     */
    public String collaborate() {
        return ", Team Member";
    }
}
