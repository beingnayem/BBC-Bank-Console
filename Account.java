public class Account{
    public int accontNo;
    public String name;
    private String phone;
    private String pin;
    private Double balance;

    public Account(String name, int accountNo, String phone){
        this.name = name;
        this.accontNo = accountNo;
        this.phone = phone;
        balance = 500.00;
    }

    public void setPin(String pin){
        this.pin = pin;
    }
    public String getPin(){
        return this.pin;
    }
    public Double getBalance(){
        return this.balance;
    }
    public void diposit(Double ammount){
        this.balance += ammount;
    }
    public void withdraw(Double ammount){
        this.balance -= ammount;
    }
    public String getPhone(){
        return this.phone;
    }
}