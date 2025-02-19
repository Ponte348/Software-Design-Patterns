import java.util.Vector;

class Database {  // Data elements 
    private Vector<Employee> employees; // Stores the employees 
    
    public Database() { 
        employees = new Vector<>(); 
    } 
    public boolean addEmployee(Employee employee) { 
     // Code to add employee 
        return employees.add(employee);
    } 
    public void deleteEmployee(long emp_num) { 
     // Code to delete employee
        for(int i=0; i<employees.size();i++){
            if(employees.get(i).getEmpNum() == emp_num){
                employees.remove(employees.get(i));
            }
        }
    } 
    public Employee[] getAllEmployees() { 
     // Code to retrieve collection 
        Employee[] employeesArr = new Employee[employees.size()];
        
        for(int i=0; i<employees.size(); i++){
            employeesArr[i] = employees.get(i);
        }

        return employeesArr;
    } 
   }