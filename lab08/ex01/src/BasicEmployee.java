import java.util.Date;

public class BasicEmployee implements Employee{
    private String name;
    private Date startDate;
    private Date endDate;

    public BasicEmployee(String name){
        this.name = name;
    }

    /** 
     * Set the start date of the employee
     * @param date
     */
    public void start(Date date){
        this.startDate = date;
    }

    /** 
     * Set the end date of the employee
     * @param date
     */
    public void terminate(Date date){
        this.endDate = date;
    }

    /** 
     * Makes the employee work
     * @return String
     */
    public String work(){
        String res = "";
        res += this.name + " is working as a ";
        res += "Regular Employee";
        return res;
    }



    public String getName(){
        return this.name;
    }
    public Date getStartDate(){
        return this.startDate;
    }
    public Date getEndDate(){
        return this.endDate;
    }
}
