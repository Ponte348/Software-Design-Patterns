
class EmployeeB{

private double salary;
private PersonB person;
	
	public EmployeeB(PersonB person, double s) {
		this.person = person;
		salary = s;
	}

	public double getSalary() {
		return salary;
	}

	public PersonB getPerson(){
		return this.person;
	}
}