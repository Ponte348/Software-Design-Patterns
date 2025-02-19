import java.util.List;
public class SharkCompany {

	public static void main(String[] args) {
		Person[] persons = { new Person("Maria Silva"),
							new Person("Manuel Pereira"),
							new Person("Aurora Machado"),
							new Person("Augusto Lima")   };
		Company shark = new Company();
		Company.user = User.OWNER;
		shark.admitEmployee(persons[0], 1000);
		shark.admitEmployee(persons[1], 900);
		shark.admitEmployee(persons[2], 1200);
		shark.admitEmployee(persons[3], 1100);
		List<Employee> sharkEmps = shark.employees();
		for (Employee e : sharkEmps)
			System.out.println(e.getSalary());
		shark.paySalaries(1);
		
		System.out.println("Permitido: " + shark.getParking().getEmployees().contains(sharkEmps.get(0)) + "\tSalário: " + sharkEmps.get(0).getSalary());
		System.out.println("Permitido: " + shark.getParking().getEmployees().contains(sharkEmps.get(1)) + "\tSalário: " + sharkEmps.get(1).getSalary());
		System.out.println("Permitido: " + shark.getParking().getEmployees().contains(sharkEmps.get(2)) + "\t\tSalário: " + sharkEmps.get(2).getSalary());
		System.out.println("Permitido: " + shark.getParking().getEmployees().contains(sharkEmps.get(3)) + "\t\tSalário: " + sharkEmps.get(3).getSalary());
	}
}