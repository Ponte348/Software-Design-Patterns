class Employee{

	private Person person;
	private double salary;
	private EmployeeCard employeeCard;
	
	public Employee(Person p, double s) {
		person = p;
		salary = s;
	}

	public double getSalary() {
		return salary;
	}

	public void paySalary(int month) {
		person.getBankAccount().deposit(salary);
	}

	public BankAccount getBankAccount() {
		return person.getBankAccount();
	}

	public void giveCard(EmployeeCard ec) {
		employeeCard = ec;
	}
}