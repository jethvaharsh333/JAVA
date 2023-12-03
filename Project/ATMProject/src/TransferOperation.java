import java.util.Scanner;

public class TransferOperation implements ATMOperation {
    @Override
    public void perform(User currentUser, String sourceAccountNumber) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter Destination Account Number: ");
            String destAccountNumber = scanner.next();
            Account destAccount = currentUser.getAccount(destAccountNumber);

            if (destAccount != null) {
                System.out.print("Enter transfer amount: $");
                double transferAmount = scanner.nextDouble();
                Account sourceAccount = currentUser.getAccount(sourceAccountNumber);
                if (sourceAccount != null) {
                    sourceAccount.transfer(transferAmount, destAccount);
                    System.out.println("Transfer successful. New balance: $" + sourceAccount.getBalance());
                } else {
                    System.out.println("Invalid source account number.");
                }
            } else {
                System.out.println("Invalid destination account number.");
            }
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Try again.");
        }
    }
}
