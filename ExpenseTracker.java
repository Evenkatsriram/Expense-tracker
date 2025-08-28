import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String date;
    double amount;
    String description;

    public Expense(String date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Amount: " + amount + ", Note: " + description;
    }
}

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        double monthlyBudget;
        System.out.print("Enter your monthly budget: ");
        monthlyBudget = sc.nextDouble();
        sc.nextLine(); // consume newline

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Monthly Summary");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter date (dd-mm-yyyy): ");
                    String date = sc.nextLine();
                    System.out.print("Enter amount spent: ");
                    double amount = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter description: ");
                    String description = sc.nextLine();
                    expenses.add(new Expense(date, amount, description));
                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    System.out.println("\nAll Expenses:");
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded.");
                    } else {
                        for (Expense e : expenses) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:
                    double total = 0;
                    for (Expense e : expenses) {
                        total += e.amount;
                    }
                    double average = expenses.isEmpty() ? 0 : total / expenses.size();
                    double remaining = monthlyBudget - total;

                    System.out.println("\nMonthly Summary:");
                    System.out.println("Total Expenses: " + total);
                    System.out.println("Average Expense: " + average);
                    System.out.println("Remaining Budget: " + remaining);
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
