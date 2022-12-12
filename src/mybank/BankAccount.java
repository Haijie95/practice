package mybank;

import java.io.Console;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.lang.IllegalArgumentException;

public class BankAccount {
    
    //members
    private String accName;
    private String accNumber;
    private Float accBalance;
    private List<String> transaction=new LinkedList<>();
    private Boolean closed=false;
    private Date accCr8Date;
    private Date accClsDate;
    //local variable
    Console cons=System.console();
    //Integer depositAmt;
    String input="";
    String trancLine="Deposit $";
    Date date=new Date();


    //constructor
    //account name only, inital balance =0f
    public BankAccount(String accName){
        this.accName=accName;
        this.accBalance=0f;
    }
    //account name & initial acc balance
    public BankAccount(String accName,Float accBalance){
        this.accName=accName;
        this.accBalance=accBalance;
    }

    //getter and setter
    //acc name cannot be change and has a read only property
    public String getAccName() {
        return accName;
    }

    //setting the account number
    public void setAccNumber(){
        Random random=new Random();
        this.accNumber=Long.toString(random.nextLong(8));
    }
    
    public String getAccNumber() {
        return accNumber;
    }

    public Float getAccBalance() {
        return accBalance;
    }
    public void setAccBalance(Float accBalance) {
        this.accBalance = accBalance;
    }

    public Boolean getClosed() {
        return closed;
    }
    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Date getAccCr8Date() {
        return accCr8Date;
    }
    public void setAccCr8Date(Date accCr8Date) {
        this.accCr8Date = accCr8Date;
    }

    public Date getAccClsDate() {
        return accClsDate;
    }
    public void setAccClsDate(Date accClsDate) {
        this.accClsDate = accClsDate;
    }
 
    //methods
    public void deposit(){
        System.out.println("How much do you want to deposit?");
        try{
            input=cons.readLine();
            //depositAmt=Integer.parseInt(input);
            if(Integer.parseInt(input)>0){
                this.accBalance=this.accBalance+Integer.parseInt(input);
                trancLine=String.format("Deposit $%d at %2$td %2$tB %2$tY %2$tT",Integer.parseInt(input),date);
                transaction.add(trancLine);
                System.out.println(trancLine);          
            } else{
                System.out.println("Please enter an amount more than $0. Thank you");
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Please enter a valid amount!");
        }
    }

    public void withdraw(){
        System.out.println(("How much do you want to withdraw?"));
        try{
        input=cons.readLine();
        if(Integer.parseInt(input)>0 && Integer.parseInt(input)<this.accBalance){
            this.accBalance=this.accBalance-Integer.parseInt(input);
            trancLine=String.format("Withdraw $%d at %2$td %2$tB %2$tY %2$tT",Integer.parseInt(input),date);
            transaction.add(trancLine);
            System.out.println(trancLine);
        } 
        //else if (Integer.parseInt(input)<=0){
        //    System.out.println("Please enter an amount more than $0. Thank you");
        //} 
        else if (Integer.parseInt(input)>this.accBalance){
            System.out.println("Invalid amount, insufficient fund in account!");
        } else{
            System.out.println("Invalid Input Please try again!");
        }
        }
        catch(IllegalArgumentException e){
            System.out.println("Please Enter a valid amount!");
        }
             
    }
}
