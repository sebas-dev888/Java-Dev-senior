package app;

import java.util.Scanner;
import model.Role;
import model.User;
import service.UserSystem;

public class App {
    public static void main(String[] args) {
        UserSystem system = new UserSystem(100, 0);
        system.createUser("1", "Admin User", "admin", "admin123", Role.ADMIN);
        system.createUser("2", "Standard User", "user", "user123", Role.STANDAR);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== User Management System ===");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Option: ");
            String option = scanner.nextLine();

            if (option.equals("2")) {
                break;
            }
            if (!option.equals("1")) {
                System.out.println("Invalid option.");
                continue;
            }

            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            User user = system.login(username, password);
            if (user == null) {
                System.out.println("Login failed. Check username and password.");
                continue;
            }

            System.out.println("Welcome, " + user.getFullName() + " (" + user.getRole() + ")");
            boolean sessionActive = true;
            while (sessionActive) {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Show history");
                System.out.println("2. Change password");
                System.out.println("3. Logout");
                if (user.getRole() == Role.ADMIN) {
                    System.out.println("4. Create user");
                    System.out.println("5. Update user");
                    System.out.println("6. Delete user");
                }
                System.out.println("7. Update my profile");
                System.out.print("Option: ");
                String action = scanner.nextLine();

                switch (action) {
                    case "1" -> user.showHistory();
                    case "2" -> {
                        System.out.print("Current password: ");
                        String current = scanner.nextLine();
                        System.out.print("New password: ");
                        String next = scanner.nextLine();
                        if (user.changePassword(current, next)) {
                            System.out.println("Password changed successfully.");
                        } else {
                            System.out.println("Could not change password. Current password is incorrect.");
                        }
                    }
                    case "3" -> {
                        user.addAction("Logged out");
                        sessionActive = false;
                    }
                    case "4" -> {
                        if (user.getRole() == Role.ADMIN) {
                            System.out.print("New user id: ");
                            String id = scanner.nextLine();
                            System.out.print("New user full name: ");
                            String name = scanner.nextLine();
                            System.out.print("New user username: ");
                            String uname = scanner.nextLine();
                            System.out.print("New user password: ");
                            String pass = scanner.nextLine();
                            System.out.print("Role (ADMIN/STANDAR): ");
                            String roleText = scanner.nextLine();
                            Role role = Role.STANDAR;
                            if ("ADMIN".equalsIgnoreCase(roleText)) {
                                role = Role.ADMIN;
                            }
                            if (system.createUser(user, id, name, uname, pass, role)) {
                                System.out.println("User created successfully.");
                            } else {
                                System.out.println("Could not create user. Id or username may already exist or you lack permissions.");
                            }
                        } else {
                            System.out.println("Option not available.");
                        }
                    }
                    case "5" -> {
                        if (user.getRole() == Role.ADMIN) {
                            System.out.print("User id to update: ");
                            String id = scanner.nextLine();
                            System.out.print("New full name (leave blank to keep): ");
                            String name = scanner.nextLine();
                            System.out.print("New password (leave blank to keep): ");
                            String pass = scanner.nextLine();
                            String currentPass = null;
                            if (!pass.isBlank()) {
                                System.out.print("Current password for this user: ");
                                currentPass = scanner.nextLine();
                            }
                            if (system.updateUser(user, id, name.isBlank() ? null : name, pass.isBlank() ? null : pass, currentPass)) {
                                System.out.println("User updated successfully.");
                            } else {
                                System.out.println("Could not update user. Verify the id, password, or permissions.");
                            }
                        } else {
                            System.out.println("Option not available.");
                        }
                    }
                    case "6" -> {
                        if (user.getRole() == Role.ADMIN) {
                            System.out.print("User id to delete: ");
                            String id = scanner.nextLine();
                            if (system.deleteUser(user, id)) {
                                System.out.println("User deleted successfully.");
                            } else {
                                System.out.println("Could not delete user. Verify the id or permissions.");
                            }
                        } else {
                            System.out.println("Option not available.");
                        }
                    }
                    case "7" -> {
                        System.out.print("New full name: ");
                        String name = scanner.nextLine();
                        System.out.print("Current password: ");
                        String current = scanner.nextLine();
                        System.out.print("New password (leave blank to keep): ");
                        String pass = scanner.nextLine();
                        if (name.isBlank() && pass.isBlank()) {
                            System.out.println("No changes provided.");
                        } else {
                            boolean updated = system.updateUser(user, user.getIdUser(), name.isBlank() ? null : name, pass.isBlank() ? null : pass, current);
                            if (updated) {
                                System.out.println("Profile updated successfully.");
                            } else {
                                System.out.println("Could not update profile. Check your current password.");
                            }
                        }
                    }
                    default -> System.out.println("Invalid option.");
                }
            }
        }
        scanner.close();
        System.out.println("Goodbye!");
    }
}
