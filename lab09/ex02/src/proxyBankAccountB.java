class proxyBankAccountB implements BankAccountB {
	
    private BankAccountB bankAccount;
    
        proxyBankAccountB(BankAccountB bankAccount) {
            this.bankAccount = bankAccount;
        }
        
        @Override public void deposit(double amount) {
                bankAccount.deposit(amount);
        }
        @Override public boolean withdraw(double amount) {
            if(CompanyB.user == UserB.COMPANY){
                System.out.println("You don't have enough permissions for this operation");
                return false;
            }
            return this.bankAccount.withdraw(amount);
        }
        @Override public double balance() {
            if(CompanyB.user == UserB.COMPANY){
                System.out.println("You don't have enough permissions for this operation");
                return 0;
            }
            return this.bankAccount.balance();
        }
    }