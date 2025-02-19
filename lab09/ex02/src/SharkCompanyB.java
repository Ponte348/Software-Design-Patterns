import java.util.List;
public class SharkCompanyB {
	public static void main(String[] args) {
			PersonB[] persons = { new PersonB("Maria Silva"),
			new PersonB("Manuel Pereira"), 
			new PersonB("Aurora Machado"), 
			new PersonB("Augusto Lima") };
			CompanyB shark = new CompanyB();
			CompanyB.user = UserB.COMPANY;
			shark.admitEmployee(persons[0], 1000);
			shark.admitEmployee(persons[1], 900);
			shark.admitEmployee(persons[2], 1200);
			shark.admitEmployee(persons[3], 1100);
			List<EmployeeB> sharkEmps = shark.employees();
			for (EmployeeB e : sharkEmps)
			System.out.println(e.getSalary());
			shark.paySalaries(1);
		}
	}