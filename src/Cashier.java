import java.util.List;

public class Cashier extends User {

    public Cashier(String username, String password) {
        super(username, password);
    }

    @Override
    public void login() {
        System.out.println("Cashier logged in.");
    }

    public void addNewBag(List<Bag> bags, Bag newBag) {
        // Assuming bags array can be dynamically expanded or using a collection like ArrayList would be better
        for (int i = 0; i < bags.size(); i++) {
            if (bags.get(i) == null) {
                bags.set(i, newBag);
                return;
            }
        }
        
    }

    public void addNewCategory(String[] categories, String newCategory) {
        // Example logic to add a new category
        // This method would need to ensure that the category isn't already in the list
    }
}
