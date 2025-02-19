import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class CompanyB {

public static UserB user;
private List<EmployeeB> emps = new ArrayList<>();

	public void admitEmployee(PersonB p, double salary) {
		EmployeeB e = new EmployeeB(p, salary);
		emps.add(e);
	}
	
	public void paySalaries(int month) {
		for (EmployeeB e : emps) {
			BankAccountB ba = e.getPerson().getBankAccount();
			ba.deposit(e.getSalary());
		}
	}
	
	public List<EmployeeB> employees() {
		return Collections.unmodifiableList(emps);
	}
}