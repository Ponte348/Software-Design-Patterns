class Person {
	
private String name;
private BankAccount bankAccount;
private BankAccount proxyAccount;

	public Person(String n) {
		name = n;
		bankAccount = new BankAccountImpl("PeDeMeia", 0);
		proxyAccount = new proxyBankAccount(bankAccount);
	}

	public String getName() {
		return name;
	}
	
	public BankAccount getBankAccount() {
			return proxyAccount;
	}
}