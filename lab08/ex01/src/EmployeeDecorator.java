import java.util.Date;

public abstract class EmployeeDecorator implements Employee{
    private Employee employee;

    /**
     * Constructor
     * @param employee
     */
    public EmployeeDecorator(Employee employee){
        this.employee = employee;
    }

    /**
     * Set the start date of the employee
     * @param date
     */
    public void start(Date date){
        this.employee.start(date);
    }
    /**
     * Set the end date of the employee
     * @param date
     */
    public void terminate(Date date){
        this.employee.terminate(date);
    }

    /**
     * Makes the employee work
     * @return String
     */
    public String work(){
        return this.employee.work();
    }
}
