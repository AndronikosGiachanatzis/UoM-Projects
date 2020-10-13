package gr.uom.android.lecture1;

public class SavingsAccount extends Account{

    private double chargingThreshold;

    public SavingsAccount(String accNumber, double initBalance, double chargingThreshold) {
        super(accNumber, initBalance);
        this.chargingThreshold = chargingThreshold;
    }

    @Override
    public double getWithdrawCost(double amount) {
        if (getBalance() > chargingThreshold)
            return 0.1;
        else
            return amount*0.047;
    }
}
