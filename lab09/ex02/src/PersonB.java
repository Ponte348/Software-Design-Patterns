class PersonB {
	
private String name;
private BankAccountB bankAccount;
private BankAccountB proxyAccount;

	public PersonB(String n) {
		name = n;
		bankAccount = new BankAccountImplB("PeDeMeia", 0);
		proxyAccount = new proxyBankAccountB(bankAccount);
	}

	public String getName() {
		return name;
	}
	
	public BankAccountB getBankAccount() {
			return proxyAccount;
	}
}