package gr.uom.android.lecture1;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World");

        Account ac1 = new SavingsAccount("111222", 0, 0);
        Account ac2 = new SimpleAccount("111333", 0, 0);


        System.out.println(ac1);
        System.out.println(ac2);


        Random randomGen = new Random();
        int amount = 3;
        List<Account> accountList = new ArrayList<>();

        for (int i=0; i<amount; i++){
            String randomString = "" + (1000000 + randomGen.nextInt(1000000));
            Account account = new SavingsAccount("GR_" + randomString, 0, 0);
            accountList.add(account);
        }

        double sum = 0;

        for (Account ac: accountList){

            ac.setBalance(100 + randomGen.nextDouble()*1000);
            System.out.println(ac);

            ac.withdraw(randomGen.nextDouble() * 10);
            sum += ac.getBalance();
        }

        System.out.println("TOTAL BALANCE = " + sum);

        System.out.println("----------------------------------------------");
        Account ac3 = new SavingsAccount("111444", 1000, 10000);
        Account ac4 = new SimpleAccount("111222", 1000, 0.12);

        boolean what = ac3.equals(ac4);
        System.out.println("Are equal? " + what);

        ac3.withdraw(100);
        ac4.withdraw(100);
    }


}
