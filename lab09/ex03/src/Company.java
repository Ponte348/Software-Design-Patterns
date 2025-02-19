import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Company {

public static User user;
	private List<Employee> emps = new ArrayList<>();
	private Insurance insurance = new Insurance();
	private SocialSecurity socialSecurity = new SocialSecurity();
	private Parking parking = new Parking();

	public void admitEmployee(Person person, double salary) {
		Employee e = new Employee(person, salary);
		emps.add(e);
		socialSecurity.registerEmployee(e);
		insurance.regist(e);
		EmployeeCard ec = new EmployeeCard(e);
		e.giveCard(ec);
		if(salary > 1000) {
			parking.allowEmployee(e);
		}
	}
	
	public void paySalaries(int month) {
		for (Employee e : emps) {
			e.paySalary(month);
		}
	}
	
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}

	public SocialSecurity getSocialSecurity() {
		return socialSecurity;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public Parking getParking() {
		return parking;
	}

}