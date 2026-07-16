import java.sql.Struct;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double balance = 2500.75;
        int Deposit = 0;
        int attempts = 0;
        int Withdraw = 0;
        boolean Continue = true;
        int PIN;
        int CountTransaction = 0;

        System.out.println("Please Enter your PIN: ");
        PIN = in.nextInt();
        if (PIN == 1234) {
            System.out.println("Login successful");

        }
        while (PIN != 1234) {
            attempts++;
            if (attempts == 3) {
                System.out.println("Account locked.");
                return;
            }

            System.out.println("Invalid PIN");
            System.out.println("Enter your PIN again: ");
            PIN = in.nextInt();


        }

        while (Continue) {
            System.out.println("==============ATM==============");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account Status");
            System.out.println("5. Exit");
            System.out.println("===============================");
            byte choice = in.nextByte();
            switch (choice) {
                case 1:
                    if (balance == 0) {
                        System.out.println("Warning! Your account is empty.");
                    }
                    System.out.println("Your balance is: " + balance);
                    break;
                case 2:
                    System.out.println("Please enter the amount to deposit");
                    Deposit = in.nextInt();
                    while (Deposit < 0) {
                        System.out.println("Invalid deposit amount. Please enter a positive value.");
                        Deposit = in.nextInt();
                    }
                    if (Deposit > 0) {
                        balance += Deposit;
                        System.out.println("Deposit successful.\n" +
                                "Your new balance is: " + balance);
                        CountTransaction++;
                    }
                    break;
                case 3:
                    System.out.println("Please enter the amount to withdraw");
                    Withdraw = in.nextInt();
                    if (Withdraw == 0) {
                        System.out.println("Withdraw cancelled.");
                        break;
                    }
                    while (Withdraw < 0 || Withdraw > balance) {
                        System.out.println("Invalid withdraw amount");
                        Withdraw = in.nextInt();
                        if (Withdraw > balance) {
                            System.out.println("Insufficient balance. Please enter a valid amount.");
                            System.out.println("Your balance is: " + balance);
                            Withdraw = in.nextInt();
                            if (Withdraw == 0) {
                                System.out.println("Withdraw cancelled.");
                                break;
                            }
                        }
                    }
                    System.out.println("Withdraw successful.\n" +
                            "Your new balance is: " + (balance - Withdraw));
                    balance -= Withdraw;
                    if (balance == 0) {
                        System.out.println("Warning! Your account is empty.");
                    }
                    CountTransaction++;
                    break;
                case 4:
                    if (balance >= 5000) {
                        System.out.println("Your account is VIP");
                    } else if (balance >= 1000) {
                        System.out.println("Your account is Regular");

                    } else if (balance < 1000) {
                        System.out.println("Your account is LOW Balance");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using ATM");


                    break;

                default:
                    System.out.println("Invalid Option. Please enter a valid option.");
                    break;


            }
            System.out.println();
            System.out.println("Do you want to continue? to continue press 1 to exit enter 0");
            int ContinueChoice = in.nextInt();
            if (ContinueChoice == 0) {
                Continue = false;
            }

        }
        System.out.println("Total number of transactions successful : " + CountTransaction);


    }
}









