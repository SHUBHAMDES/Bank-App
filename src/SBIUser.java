import java.util.Objects;
import java.util.UUID;

public class SBIUser implements BankInterface{
    //attribute or variable

    private String name;
    private String accountNo;
    private double balance;
    private String password;

    private  double rateInterest;

    //constoctore
    public SBIUser(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        //bank is initialisation
        this.rateInterest=6.5;
        this.accountNo=String.valueOf(UUID.randomUUID());

    }
//gater seter method
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRateInterest() {
        return rateInterest;
    }

    public void setRateInterest(double rateInterest) {
        this.rateInterest = rateInterest;
    }

    @Override//annotation (Spring boot is all abount annotation)
    public double checkBalance() {
        return this.balance;

    }

    @Override
    public String addMoney(int amount) {
        balance=balance+amount;
        return "Your new Balance:->"+balance;
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {
        if(Objects.equals(enteredPassword,password)){
           if(amount>balance){
               return "Sorry Bro ! Insuficient Money";
           }
           else{
               balance=balance-amount;
               return "Paisa hi paisa(Lots of money)";
           }
        }
        else {
            return "Wrong password !";
        }

    }

    @Override
    public double calculateInterest(int years) {
        return (balance*years*rateInterest)/100;//formula
    }


    //


}
