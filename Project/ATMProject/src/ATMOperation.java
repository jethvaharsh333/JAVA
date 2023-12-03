public interface ATMOperation {
    void perform(User currentUser, String sourceAccountNumber);
}