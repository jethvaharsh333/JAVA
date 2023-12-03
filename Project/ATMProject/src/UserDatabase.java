import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private List<User> users;

    public UserDatabase() {
        this.users = new ArrayList<>();
        initializeUsers();					// initial users
    }

    private void initializeUsers() {
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");

        Account account1a = new Account("1111");
        Account account1b = new Account("1112");
        user1.getAccounts().add(account1a);
        user1.getAccounts().add(account1b);

        Account account2a = new Account("2222");
        user2.getAccounts().add(account2a);

        users.add(user1);
        users.add(user2);
    }

    public User authenticateUser(String userId, String enteredPassword) {
        for (User user : users) {
            if (user.getUserId().equals(userId) && user.authenticate(enteredPassword)) {
                return user;
            }
        }
        return null; // User not found or invalid credentials
    }
}
