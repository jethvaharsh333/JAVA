import java.util.Scanner;

public class ATM {
    private static User currentUser;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User database
        UserDatabase userDatabase = new UserDatabase();

        // ATM login
        System.out.println("Welcome to the ATM!");
        System.out.print("Enter User ID: ");
        String userId = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();

        currentUser = userDatabase.authenticateUser(userId, password);

        if (currentUser != null) {
            System.out.println("Login successful!\n");
            performATMOperations(scanner);
        } else {
            System.out.println("Invalid credentials. Exiting.");
        }
    }

    private static void performATMOperations(Scanner scanner) {
        while (true) {
            System.out.println("ATM INTERFACE : ");
            System.out.println("1. View Accounts");
            System.out.println("2. View Transactions History");
            System.out.println("3. Withdraw");
            System.out.println("4. Deposit");
            System.out.println("5. Transfer");
            System.out.println("6. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAccounts(currentUser);
                    break;
                case 2:
                    viewTransactionHistory(currentUser);
                    break;
                case 3:
                    performOperation(new WithdrawOperation(), scanner);
                    break;
                case 4:
                    performOperation(new DepositOperation(), scanner);
                    break;
                case 5:
                    performOperation(new TransferOperation(), scanner);
                    break;
                case 6:
                    performOperation(new QuitOperation(), scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void viewAccounts(User currentUser) {
        System.out.println("Accounts:");
        for (Account account : currentUser.getAccounts()) {
            System.out.println(account.getAccountNumber() + " - Balance: $" + account.getBalance());
        }
        System.out.println();
    }

    private static void viewTransactionHistory(User currentUser) {
        System.out.println("Transaction History:");
        for (Account account : currentUser.getAccounts()) {
            System.out.println("Account " + account.getAccountNumber() + ": " + account.getTransactionHistory());
        }
        System.out.println();
    }

    private static void performOperation(ATMOperation operation, Scanner scanner) {
        if (operation instanceof QuitOperation) {
            operation.perform(null, null);
        } else {
            viewAccounts(currentUser);
            System.out.print("Enter Source Account Number: ");
            String sourceAccountNumber = scanner.next();
            operation.perform(currentUser, sourceAccountNumber);
        }
    }
}
