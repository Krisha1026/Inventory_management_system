import java.util.List;

public abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public abstract void login();

    public void viewAllBags(List<Bag> bags) {
        System.out.println("Bag ID | Bag Name         | Bag Category | Price");
        System.out.println("--------------------------------------------------");
        boolean found = false;
        for (Bag bag : bags) {
            if (bag != null) {
                System.out.printf("%-6d | %-15s | %-12s | $%.2f%n",
                        bag.getId(),
                        bag.getName(),
                        bag.getCategory(),
                        bag.getPrice()
                );
                found = true;
            }
        }
        if (!found) {
            System.out.println("No bags available.");
        }
    }

    public void searchBagsByCategory(List<Bag> bags, String category) {
        boolean found = false;
        for (Bag bag : bags) {
            if (bag != null && bag.getCategory().equalsIgnoreCase(category.trim())) {
                System.out.println(bag);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No bags found in the category: " + category);
        }
    }
}
