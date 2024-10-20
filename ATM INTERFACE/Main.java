import java.util.Scanner;

class atmmachine {
    private bankaccount useraccount;

    public atmmachine(bankaccount account) {
        this.useraccount = account;
    }

    public void showmenu() {
        System.out.println("Welcome to ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Cancel");
    }

    public void withdraw(float amount) {
        if (amount > 0 && amount <= useraccount.getbalance()) {
            useraccount.setbalance(useraccount.getbalance() - amount);
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void deposit(float amount) {
        if (amount > 0) {
            useraccount.setbalance(useraccount.getbalance() + amount);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void checkbalance() {
        System.out.println("Your balance is: " + useraccount.getbalance());
    }
}

class bankaccount {
    private float balance;

    public bankaccount(float initialbalance) {
        this.balance = initialbalance;
    }

    public float getbalance() {
        return balance;
    }

    public void setbalance(float balance) {
        this.balance = balance;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        bankaccount useraccount = new bankaccount(1000.0f); 
        atmmachine atm = new atmmachine(useraccount);

        int choice;
        do {
            atm.showmenu();
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    float withdrawamount = scanner.nextFloat();
                    atm.withdraw(withdrawamount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    float depositamount = scanner.nextFloat();
                    atm.deposit(depositamount);
                    break;
                case 3:
                    atm.checkbalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid option. ");
            }
        } while (choice != 4);
        
        scanner.close();
    }
}
