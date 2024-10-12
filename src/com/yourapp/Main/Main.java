package com.yourapp.Main;
import com.yourapp.Habit.Habit;
import com.yourapp.TrackHabitDAO.TrackHabitDAO;
import com.yourapp.User.User;
import com.yourapp.UserDAO.UserDAO;
import com.yourapp.HabitStatistics.HabitStatistics;
import com.yourapp.HabitStatisticsExample.HabitStatisticsExample;
import java.util.Date;
import java.util.Scanner;
import com.yourapp.HabitDAO.HabitDAO;


public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        HabitDAO habitDAO = new HabitDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("*1. Register");
            System.out.println("*2. Login");
            System.out.println("*3. Edit Profile");
            System.out.println("*4. Delete Account");
            System.out.println("*5. Create Habit");
            System.out.println("*6. Edit Habit");
            System.out.println("*7. Delete Habit");
            System.out.println("*8. Exit");
            System.out.println("*9. Streak");


            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerUser(userDAO, scanner);
                    break;
                case 2:
                    loginUser(userDAO, scanner);
                    break;
                case 3:
                    editUserProfile(userDAO, scanner);
                    break;
                case 4:
                    deleteUser(userDAO, scanner);
                    break;
                case 5:
                    createHabit(habitDAO, scanner);
                    break;
                case 6:
                    editHabit(habitDAO, scanner);
                    break;
                case 7:
                    deleteHabit(habitDAO, scanner);
                    break;
                case 8:
                    System.exit(0);
                    break;
                case 9:
                    generateProgressReport(habitDAO, scanner);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }


    private static void createHabit(HabitDAO habitDAO, Scanner scanner) {
        System.out.println("Enter habit name:");
        String name = scanner.next();
        System.out.println("Enter habit description:");
        String description = scanner.next();
        System.out.println("Enter habit frequency:");
        String frequency = scanner.next();

        Habit habit = new Habit(name, description, frequency);
        habitDAO.createHabit(habit);
        System.out.println("Habit created successfully!");
    }

    private static void editHabit(HabitDAO habitDAO, Scanner scanner) {
        System.out.println("Enter habit name:");
        String name = scanner.next();

        Habit habit = habitDAO.getHabit(name);
        if (habit != null) {
            System.out.println("Enter new habit name:");
            String newName = scanner.next();
            System.out.println("Enter new habit description:");
            String newDescription = scanner.next();
            System.out.println("Enter new habit frequency:");
            String newFrequency = scanner.next();

            habitDAO.editHabit(habit, newName, newDescription, newFrequency);
            System.out.println("Habit updated successfully!");
        } else {
            System.out.println("Habit not found");
        }
    }

    private static void deleteHabit(HabitDAO habitDAO, Scanner scanner) {
        System.out.println("Enter habit name:");
        String name = scanner.next();

        Habit habit = habitDAO.getHabit(name);
        if (habit != null) {
            habitDAO.deleteHabit(habit);
            System.out.println("Habit deleted successfully!");
        } else {
            System.out.println("Habit not found");
        }
    }
    private static void editUserProfile(UserDAO userDAO, Scanner scanner) {
        System.out.println("Enter email:");
        String email = scanner.next();

        User user = userDAO.loginUser(email, "");
        if (user != null) {
            System.out.println("Enter new name:");
            String name = scanner.next();
            System.out.println("Enter new email:");
            String newEmail = scanner.next();
            System.out.println("Enter new password:");
            String password = scanner.next();

            userDAO.editUserProfile(user, name, newEmail, password);
            System.out.println("Profile updated successfully!");
        } else {
            System.out.println("User not found");
        }
    }

    private static void deleteUser(UserDAO userDAO, Scanner scanner) {
        System.out.println("Enter email:");
        String email = scanner.next();

        User user = userDAO.loginUser(email, "");
        if (user != null) {
            userDAO.deleteUser(user);
            System.out.println("Account deleted successfully!");
        } else {
            System.out.println("User not found");
        }
    }

    private static void registerUser (UserDAO userDAO, Scanner scanner) {
        System.out.println("Enter email:");
        String email = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        System.out.println("Enter name:");
        String name = scanner.next();

        User user = new User(email, password, name);
        userDAO.registerUser (user);
        System.out.println("User  registered successfully!");
    }

    private static void loginUser(UserDAO userDAO, Scanner scanner) {
        System.out.println("Enter email:");
        String email = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();

        User user = userDAO.loginUser (email, password);
        if (user != null) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid email or password");
        }
    }

    private static void deleteTrackHabit(TrackHabitDAO trackHabitDAO, Scanner scanner) {
        System.out.println("Enter habit name:");
        String habitName = scanner.next();

    }
    private static void generateProgressReport(HabitDAO habitDAO, Scanner scanner) {
        System.out.println("Enter habit name:");
        String habitName = scanner.next();
        Habit habit = habitDAO.getHabit(habitName);

        if (habit != null) {
            int streak = HabitStatistics.getStreak(habit);
            double successRate = HabitStatistics.getSuccessRate(habit, new Date(), new Date());

            System.out.println("Current streak: " + streak);
            System.out.println("Success rate: " + successRate + "%");
        } else {
            System.out.println("Habit not found.");
        }
    }
}