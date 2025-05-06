import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LittleBagShop {
    public static void main(String[] args) {
        List<Bag> bags = new ArrayList<>();
        List<User> users = new ArrayList<>();
        users.add(new Manager("admin", "admin123")); // Predefined manager account
        users.add(new Cashier("cashier1", "password")); // Predefined cashier account

        bags.add(new Bag(1, "Classic Tote", "Totes", 49.99, 10));
        bags.add(new Bag(2, "Leather Backpack", "Backpacks", 89.99, 5));
        bags.add(new Bag(3, "Canvas Messenger", "Messenger", 39.99, 7));
        bags.add(new Bag(4, "Evening Clutch", "Clutches", 59.99, 3));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to The Little Bag Shop System!");

        System.out.println("Select user role: 1. Cashier 2. Manager");
        int roleSelection = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        User currentUser = null;

        if (roleSelection == 1) {
            System.out.println("Enter cashier username:");
            String username = scanner.nextLine();
            System.out.println("Enter cashier password:");
            String password = scanner.nextLine();

            for (User user : users) {
                if (user instanceof Cashier && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    currentUser = user;
                    break;
                }
            }

            if (currentUser != null) {
                currentUser.login();
                boolean exit = false;

                while (!exit) {
                    System.out.println("\nCashier Menu: ");
                    System.out.println("1. View all bags");
                    System.out.println("2. Add new bag");
                    System.out.println("3. Add new category");
                    System.out.println("4. Search bags by category (Tote, Backpack, Messenger, Clutches)");
                    System.out.println("5. Exit");

                    int selection = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (selection) {
                        case 1:
                            System.out.println("\n--- All Bag Details ---");
                            currentUser.viewAllBags(bags);
                            break;
                        case 2:
                            System.out.println("Enter bag ID:");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter bag name:");
                            String name = scanner.nextLine();
                            System.out.println("Enter bag category:");
                            String category = scanner.nextLine();
                            System.out.println("Enter bag price:");
                            double price = scanner.nextDouble();
                            System.out.println("Enter bag quantity:");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();
                            ((Cashier) currentUser).addNewBag(bags, new Bag(id, name, category, price, quantity));
                            System.out.println("New bag added successfully!");
                            break;
                        case 3:
                            System.out.println("Enter new category:");
                            String newCategory = scanner.nextLine();
                            // You should have logic to handle new category addition
                            System.out.println("New category added successfully!");
                            break;
                        case 4:
                            System.out.println("Enter category to search (Tote, Backpack, Messenger, Clutches):");
                            String searchCategory = scanner.nextLine();
                            System.out.println("\n--- Search Results for Category: " + searchCategory + " ---");
                            currentUser.searchBagsByCategory(bags, searchCategory);
                            break;
                        case 5:
                            exit = true;
                            System.out.println("Exiting Cashier Menu.");
                            break;
                        default:
                            System.out.println("Invalid selection, please try again.");
                    }
                }
            } else {
                System.out.println("Invalid login credentials for cashier.");
            }
        } else if (roleSelection == 2) {
            System.out.println("Enter manager username:");
            String username = scanner.nextLine();
            System.out.println("Enter manager password:");
            String password = scanner.nextLine();

            for (User user : users) {
                if (user instanceof Manager && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    currentUser = user;
                    break;
                }
            }

            if (currentUser != null) {
                currentUser.login();
                boolean exit = false;

                while (!exit) {
                    System.out.println("\nManager Menu: ");
                    System.out.println("1. View all bags");
                    System.out.println("2. Add new bag");
                    System.out.println("3. Add new category");
                    System.out.println("4. Search bags by category (Tote, Backpack, Messenger, Clutches)");
                    System.out.println("5. Create new cashier account");
                    System.out.println("6. Exit");

                    int selection = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (selection) {
                        case 1:
                            System.out.println("\n--- All Bag Details ---");
                            currentUser.viewAllBags(bags);
                            break;
                        case 2:
                            System.out.println("Enter bag ID:");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter bag name:");
                            String name = scanner.nextLine();
                            System.out.println("Enter bag category:");
                            String category = scanner.nextLine();
                            System.out.println("Enter bag price:");
                            double price = scanner.nextDouble();
                            System.out.println("Enter bag quantity:");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();
                            ((Cashier) currentUser).addNewBag(bags, new Bag(id, name, category, price, quantity));
                            System.out.println("New bag added successfully!");
                            break;
                        case 3:
                            System.out.println("Enter new category:");
                            String newCategory = scanner.nextLine();
                            // You should have logic to handle new category addition
                            System.out.println("New category added successfully!");
                            break;
                        case 4:
                            System.out.println("Enter category to search (Tote, Backpack, Messenger, Clutches):");
                            String searchCategory = scanner.nextLine();
                            System.out.println("\n--- Search Results for Category: " + searchCategory + " ---");
                            currentUser.searchBagsByCategory(bags, searchCategory);
                            break;
                        case 5:
                            System.out.println("Enter new cashier username:");
                            String newUsername = scanner.nextLine();
                            System.out.println("Enter new cashier password:");
                            String newPassword = scanner.nextLine();
                            ((Manager) currentUser).createUserAccount(users.toArray(new User[0]), newUsername, newPassword);
                            System.out.println("New cashier account created successfully!");
                            break;
                        case 6:
                            exit = true;
                            System.out.println("Exiting Manager Menu.");
                            break;
                        default:
                            System.out.println("Invalid selection, please try again.");
                    }
                }
            } else {
                System.out.println("Invalid login credentials for manager.");
            }
        } else {
            System.out.println("Invalid role selection.");
        }

        scanner.close();
    }
}
