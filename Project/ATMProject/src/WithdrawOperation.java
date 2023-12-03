import java.util.Scanner;

public class WithdrawOperation implements ATMOperation {
    @Override
    public void perform(User currentUser, String sourceAccountNumber) {
        Scanner scanner = new Scanner(System.in);
        try {
            Account sourceAccount = currentUser.getAccount(sourceAccountNumber);
            if (sourceAccount != null) {
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                sourceAccount.withdraw(withdrawalAmount);
                System.out.println("Withdrawal successful. New balance: $" + sourceAccount.getBalance());
            } else {
                System.out.println("Invalid account number.");
            }
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Try again.");
        }
    }
}
