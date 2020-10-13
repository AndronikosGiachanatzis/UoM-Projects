package gr.uom.android.lecture1;

public class SimpleAccount extends Account{

    private double cost;


    public SimpleAccount(String accNumber, double initBalance, double cost) {
        super(accNumber, initBalance);
        this.cost = cost;
    }

    @Override
    public double getWithdrawCost(double amount) {
        return cost;
    }
}
