package mybank;

import mybank.BankAccount;
import mybank.FixedDepositAccount;

public class Main {
    
    public static void main(String[] args){
        Float totalMoney=0f;


        BankAccount accOne=new BankAccount("John");
        FixedDepositAccount fixAccOne=new FixedDepositAccount("David", 100f);

        accOne.getAccNumber();
        System.out.println(accOne.getAccNumber());

        accOne.deposit();
        System.out.println(accOne.getAccBalance());

        accOne.withdraw();
        System.out.println(accOne.getAccBalance());

        fixAccOne.deposit();
        totalMoney=fixAccOne.getBalance();
        System.out.printf("Total amount: $%.2f",totalMoney);

        

    }
}
