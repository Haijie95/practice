package mybank;

public class FixedDepositAccount extends BankAccount {
    
    //inheritance
    public FixedDepositAccount(String name, Float balance){
        super(name,balance);
    }
    public FixedDepositAccount(String name, Float balance, Float interest){
        super(name,balance);
        this.interest=interest;
    }
    public FixedDepositAccount(String name, Float balance, Float interest, Integer duration){
        super(name,balance);
        this.interest=interest;
        this.duration=duration;
    }

    //members
    private Float interest=3f;
    private Integer duration=6;
    private Float totalBalance=0f;

    private Integer countI=1;
    private Integer countD=1;
    

    public Float getInterest() {
        return interest;
    }
    public void setInterest(Float interest) {
        if (countI>=1);{

        }else{
            this.interest = interest;
            countI++;
        }
    }
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    //override super method
    @Override
    public void withdraw(){
        //no operation
    }
    @Override
    public void deposit(){
        //no operation
    }

    public Float getBalance(){
        this.totalBalance=super.getAccBalance()+(super.getAccBalance()*this.interest/100);
        //System.out.printf("Total Balance: %f",totalBalance);
        return this.totalBalance;
    }
}
