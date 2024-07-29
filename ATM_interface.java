import java.util.Scanner;

class ATM {
    private int balance;
    private int pin;

    public ATM(int balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Change PIN");
        System.out.println("5. Exit");
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    public void withdrawCash(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        }
    }

    public void depositCash(int amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void changePIN(int newPIN) {
        pin = newPIN;
        System.out.println("PIN changed successfully!");
    }

    public boolean authenticate(int inputPIN) {
        return inputPIN == pin;
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000, 1234);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    atm.withdrawCash(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    atm.depositCash(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter new PIN: ");
                    int newPIN = scanner.nextInt();
                    atm.changePIN(newPIN);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.print("Enter your PIN to continue: ");
            int inputPIN = scanner.nextInt();

            if (!atm.authenticate(inputPIN)) {
                System.out.println("Invalid PIN. Exiting...");
                return;
            }
        }
    }
}