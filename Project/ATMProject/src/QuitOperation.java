public class QuitOperation implements ATMOperation {
    @Override
    public void perform(User currentUser, String sourceAccountNumber) {
        System.out.println("Thank you for using the ATM. Exiting.");
        System.exit(0);
    }
}
