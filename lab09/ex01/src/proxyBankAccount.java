class proxyBankAccount implements BankAccount {
	
    private BankAccount bankAccount;
    
        proxyBankAccount(BankAccount bankAccount) {
            this.bankAccount = bankAccount;
        }
        
        @Override public void deposit(double amount) {
                bankAccount.deposit(amount);
        }
        @Override public boolean withdraw(double amount) {
            if(Company.user == User.COMPANY){
                System.out.println("You don't have enough permissions for this operation");
                return false;
            }
            return this.bankAccount.withdraw(amount);
        }
        @Override public double balance() {
            if(Company.user == User.COMPANY){
                System.out.println("You don't have enough permissions for this operation");
                return 0;
            }
            return this.bankAccount.balance();
        }
    }