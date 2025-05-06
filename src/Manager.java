import java.util.List;

public class Manager extends Cashier {

    public Manager(String username, String password) {
        super(username, password);
    }

    @Override
    public void login() {
        System.out.println("Manager logged in.");
    }

    public void createUserAccount(User[] users, String username, String password) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = new Cashier(username, password);
                System.out.println("New cashier account created.");
                return;
            }
        }
        
    }
}
