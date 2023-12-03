import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String passwordHash;
    private List<Account> accounts;

    public User(String userId, String passwordHash) {
        this.userId = userId;
        this.passwordHash = passwordHash;
        this.accounts = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public List<Account> getAccounts() {		// provide list of accounts
        return accounts;
    }

    public Account getAccount(String accountNumber) {		//searching only one account among accounts which user wants
        return accounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    public boolean authenticate(String enteredPassword) {		// authentication of password
        return passwordHash.equals(enteredPassword);
    }
}