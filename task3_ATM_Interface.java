package src.method;
import java.util.Scanner;

//Class representing the user's bank account
class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     balance += amount;
 }

 public boolean withdraw(double amount) {
     if (amount <= balance) {
         balance -= amount;
         return true; // Withdrawal successful
     } else {
         return false; // Insufficient funds
     }
 }
}

//Class representing the ATM machine
class ATM {
 private BankAccount userAccount;
 private Scanner scanner;

 public ATM(BankAccount userAccount) {
     this.userAccount = userAccount;
     this.scanner = new Scanner(System.in);
 }

 // Display ATM menu
 private void displayMenu() {
     System.out.println("ATM Menu:");
     System.out.println("1. Withdraw");
     System.out.println("2. Deposit");
     System.out.println("3. Check Balance");
     System.out.println("4. Exit");
     System.out.print("Choose an option from (1 to 4): ");
 }

 // Method to handle user input and perform transactions
 public void operate() {
     int choice;

     do {
         displayMenu();
         choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 // Withdraw
                 System.out.print("Enter withdrawal amount: ");
                 double withdrawAmount = scanner.nextDouble();
                 if (userAccount.withdraw(withdrawAmount)) {
                     System.out.println("Withdrawal successful. Remaining balance: $" + userAccount.getBalance());
                 } else {
                     System.out.println("Insufficient funds. Withdrawal failed.");
                 }
                 break;

             case 2:
                 // Deposit
                 System.out.print("Enter deposit amount: ");
                 double depositAmount = scanner.nextDouble();
                 userAccount.deposit(depositAmount);
                 System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
                 break;

             case 3:
                 // Check Balance
                 System.out.println("Current balance: $" + userAccount.getBalance());
                 break;

             case 4:
                 // Exit
                 System.out.println("Exiting ATM. Thank you!");
                 break;

             default:
                 System.out.println("Invalid option. Please choose a valid option.");
                 break;
         }

     } while (choice != 4);
 }

 // Close the scanner to avoid resource leak
 public void closeScanner() {
     scanner.close();
 }
}

//Main class to run the ATM application
public class task3_ATM_Interface {
 public static void main(String[] args) {
     // Initialize user's bank account with an initial balance
     BankAccount userAccount = new BankAccount(1000.0);

     // Create an ATM object and pass the user's bank account to it
     ATM atm = new ATM(userAccount);

     // Operate the ATM
     atm.operate();

     // Close the scanner
     atm.closeScanner();
 }
}
