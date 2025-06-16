import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    public Map<Integer, Account> accounts;
    public int baseAccountNo = 1000;
    public Boolean signin;

    public Bank(){
        accounts = new HashMap<>();
        signin = false;
    }
    public Account createAccount(){
        baseAccountNo += 1;
        Scanner ob = new Scanner(System.in);
        
        System.out.print("Enter Your Name: ");
        String name = ob.nextLine(); 
        System.out.print("Enter Your Phone Number: ");
        String phone = ob.nextLine(); 
        
        Account ac = new Account(name, baseAccountNo, phone);
        accounts.put(baseAccountNo, ac);
        
        System.out.println("Set your account PIN");
        System.out.print("Enter New PIN: ");
        String pin = ob.nextLine();
        
        ac.setPin(pin);
        this.signin=true;
        System.out.println("=======================================================");
        System.out.print("\n");
        System.out.println("            Account created succesfully.");
        System.out.println("            Account Holder Name: "+ac.name);
        System.out.println("            Account Number: "+ac.accontNo);
        System.out.print("\n");
        System.out.println("=======================================================");
        
        return ac;
    }
    public Account login(){
        Scanner ob = new Scanner(System.in);
        
        System.out.print("Enter Account No: ");
        int accountNo = ob.nextInt();
        ob.nextLine();
        System.out.print("Enter PIN: ");
        String pin = ob.nextLine();
        
        Account ac = accounts.get(accountNo);
    
        if(ac != null && pin.equals(ac.getPin())){
            this.signin = true;
            System.out.println("========================================");
            System.out.print("\n");
            System.out.println("            Login successful.");
            System.out.print("\n");
            System.out.println("========================================");
        }
        else{
            System.out.println("=====================================================");
            System.out.print("\n");
            System.out.println("            Wrong Account No or PIN, try again.");
            System.out.print("\n");
            System.out.println("=====================================================");
        }
        return ac;
    }
    public void logout(){
        this.signin = false;
        System.out.println("========================================");
        System.out.print("\n");
        System.out.println("            Logout successful.");
        System.out.print("\n");
        System.out.println("========================================");
    }
    public void depositCash(Account ac){
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter Deposit Ammount: ");
        Double ammount = ob.nextDouble();
        ac.diposit(ammount);
        System.out.println("=======================================================");
        System.out.print("\n");
        System.out.println("            Deposit Successful.");
        System.out.println("            Current balance is "+ac.getBalance());
        System.out.print("\n");
        System.out.println("=======================================================");
    }
    public void withdrawCash(Account ac){
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter Withdraw Ammount: ");
        Double ammount = ob.nextDouble();
        ac.withdraw(ammount);
        System.out.println("=======================================================");
        System.out.print("\n");
        System.out.println("            Withdraw Successful.");
        System.out.println("            Current balance is "+ac.getBalance());
        System.out.print("\n");
        System.out.println("=======================================================");
    }
    public Boolean changePin(Account ac){
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter Current PIN: ");
        String curPin = ob.nextLine();
        if(curPin.equals(ac.getPin())){
            System.out.print("Enter New PIN: ");
            String newPin = ob.nextLine();
            ac.setPin(newPin);
            signin = false;

            System.out.println("==================================================================================");
            System.out.print("\n");
            System.out.println("            New PIN is updated. Currently you are loged out, login again.");
            System.out.print("\n");
            System.out.println("==================================================================================");
            
            return true;
        }
        else{
            System.out.println("====================================================");
            System.out.print("\n");
            System.out.println("            Current PIN is wrong, try again.");
            System.out.print("\n");
            System.out.println("====================================================");
            return false;
        }
    }
    public void getInfo(Account ac){
        System.out.println("=============================================================");
        System.out.print("\n");
        System.out.println("            Account holder name: "+ac.name);
        System.out.println("            Account number: "+ac.accontNo);
        System.out.println("            Account holder Phone: "+ac.getPhone());
        System.out.println("            Current balance: "+ac.getBalance());
        System.out.print("\n");
        System.out.println("=============================================================");
    }
    public void fundTransfer(Account to){
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter Reciver Account No: ");
        int reciverAccountNO = ob.nextInt();
        ob.nextLine();
        Account reciver = accounts.get(reciverAccountNO);
        if(reciver != null && to.accontNo != reciverAccountNO){
            System.out.print("Enter Ammount: ");
            Double ammount = ob.nextDouble();
            System.out.print("Enter PIN: ");
            ob.nextLine();
            String pin = ob.nextLine();
            if(pin.equals(to.getPin())){
                reciver.diposit(ammount);
                to.withdraw(ammount);
                System.out.println("==========================================================================================");
                System.out.print("\n");
                System.out.println("            TK. " + ammount + "has been transfered to account "+reciver.accontNo);
                System.out.print("\n");
                System.out.println("==========================================================================================");
            }
            else{
                System.out.println("====================================================================");
                System.out.print("\n");
                System.out.println("            Wrong PIN, try again.");
                System.out.print("\n");
                System.out.println("====================================================================");
            }
        }
        else{
            System.out.println("==================================================");
            System.out.print("\n");
            System.out.println("            Enter A Valid Reciver Account No.");
            System.out.print("\n");
            System.out.println("==================================================");
        }
        
    }
    public void checkBalance(Account ac){
        System.out.println("================================================================================");
        System.out.print("\n");
        System.out.println("            Current Balance for account "+ac.accontNo+" is "+ac.getBalance());
        System.out.print("\n");
        System.out.println("================================================================================");
    }

    public static void main(String[] args){
        Bank bbcBank = new Bank();
        Scanner ob = new Scanner(System.in);
        while(true){
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Close Programme");
            System.out.print("Select option 1-3: ");
            int act = ob.nextInt();
            if(act == 3){
                System.out.println("==================================================");
                System.out.print("\n");
                System.out.println("            Thanks for using BBC Bank.");
                System.out.print("\n");
                System.out.println("==================================================");
                break;
            }
            else if(act == 1 || act == 2){
                Account ac;
                if(act == 2){
                    ac = bbcBank.createAccount();
                }
                else{
                    ac = bbcBank.login();
                    if(ac == null){
                        continue;
                    }
                }
                while(bbcBank.signin == true){
                    System.out.println("1. Check Balance");
                    System.out.println("2. Deposit Cash");
                    System.out.println("3. Withdraw Cash");
                    System.out.println("4. Change PIN");
                    System.out.println("5. Account Details");
                    System.out.println("6. Fund Transfer");
                    System.out.println("7. Logout");
                    System.out.print("Select option 1-7: ");
                    int opt = ob.nextInt();
                    if(opt == 1){
                        bbcBank.checkBalance(ac);
                    }
                    else if(opt == 2){
                        bbcBank.depositCash(ac);
                    }
                    else if(opt == 3){
                        bbcBank.withdrawCash(ac);
                    }
                    else if(opt == 4){
                        bbcBank.changePin(ac);
                    }
                    else if(opt == 5){
                        bbcBank.getInfo(ac);
                    }
                    else if(opt == 6){
                        bbcBank.fundTransfer(ac);
                    }
                    else if(opt == 7){
                        bbcBank.logout();
                    }
                    else{
                        System.out.println("            Wrong option, try again.");
                    }
                }
            }
            else{
                System.out.println("            Wrong option, try again.");
            }
        }
        ob.close();
    }
}
