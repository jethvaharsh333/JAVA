import java.util.Scanner;

public class DepositOperation implements ATMOperation {
    @Override
    public void perform(User currentUser, String sourceAccountNumber) {
		Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Choose deposit type:");
            System.out.println("1. Cash Deposit");
            System.out.println("2. Cheque Deposit");
            System.out.print("Enter your choice: ");
            int depositType = scanner.nextInt();

            switch (depositType) {
                case 1:
                    performCashDeposit(currentUser, sourceAccountNumber);
                    break;
                case 2:
                    performChequeDeposit(currentUser, sourceAccountNumber);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Try again.");
        }
    }

    private void performCashDeposit(User currentUser, String sourceAccountNumber) {
        Scanner scanner = new Scanner(System.in);
        try {
            Account sourceAccount = currentUser.getAccount(sourceAccountNumber);
            if (sourceAccount != null) {
                System.out.print("Enter cash deposit amount: $");
                double depositAmount = scanner.nextDouble();
                sourceAccount.depositCash(depositAmount);
                System.out.println("Cash deposit successful. New balance: $" + sourceAccount.getBalance());
            } else {
                System.out.println("Invalid account number.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Try again.");
        }
    }

    private void performChequeDeposit(User currentUser, String sourceAccountNumber) {
        Scanner scanner = new Scanner(System.in);
        try {
            Account sourceAccount = currentUser.getAccount(sourceAccountNumber);
            if (sourceAccount != null) {
                System.out.print("Enter cheque deposit amount: $");
                double depositAmount = scanner.nextDouble();
                sourceAccount.depositCheque(depositAmount);
                System.out.println("Cheque deposit successful. New balance: $" + sourceAccount.getBalance());
            } else {
                System.out.println("Invalid account number.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Try again.");
        }
    }
}
