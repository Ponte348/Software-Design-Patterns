public class BankAccountProxy implements BankAccount{
    private BankAccountImpl bankAccount;

    public BankAccountProxy(String bankAccountName, double deposit) {
        this.bankAccount = new BankAccountImpl(bankAccountName, deposit);
    }

    public boolean checkAccess() {
        if(Company.user == User.OWNER) {
            return true;
        }
        return false;
    }

    @Override
    public void deposit(double amount) {
        this.bankAccount.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if(checkAccess()) {
            return this.bankAccount.withdraw(amount);
        }
        return false;     
    }

    @Override
    public double balance() {
        if(checkAccess()) {
            return this.bankAccount.balance();
        }
        return 0;
    }
}
