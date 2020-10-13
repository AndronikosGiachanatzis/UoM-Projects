package gr.uom.android.lecture1;

public abstract class Account {

    private String accountNumber;
    // double is a wrong implementation of a variable that stores currency values
    private double balance;

    public Account(String accNumber) {

        // Comment
        accountNumber = accNumber;
        balance = 0;
    }

    public Account(String accNumber, double initBalance) {

        accountNumber = accNumber;
        balance = initBalance;
    }
    public void withdraw(double amount){
        double cost = getWithdrawCost(amount);
        System.out.println(" withdraw cost = " + cost);
        amount = amount + cost;
        if (this.balance - amount <= 0)
            this.balance = 0;
        else {
            this.balance -= amount;
        }

        System.out.println("WITHDRAW of " + amount + ". New balance = " + balance);
    }

    public abstract double getWithdrawCost(double amount);

    @Override
    public String toString() {
        return "Account No " + accountNumber + "Current Balance = " + balance;
    }


    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Account) {
            Account other = (Account)obj;
            return (this.hashCode() == other.hashCode());
        }

        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
