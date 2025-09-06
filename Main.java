import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome ===");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Learner");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // clear newline

        if (choice == 1) {
            Admin admin = new Admin(1, "AdminUser", "admin@example.com");
            boolean adminLoggedIn = true;

            while (adminLoggedIn) {
                admin.showDashboard();
                System.out.print("Enter choice: ");
                int c = sc.nextInt();
                sc.nextLine();
                switch (c) {
                    case 1:
                        AdminAddTopic.addTopic(sc);
                        break;
                    case 2:
                        AdminViewStats.viewStats();
                        break;
                    case 3:
                        adminLoggedIn = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else if (choice == 2) {
            Learner learner = new Learner(2, "Ak", "ak@example.com");
            boolean learnerLoggedIn = true;

            while (learnerLoggedIn) {
                learner.showDashboard();
                System.out.print("Enter choice: ");
                int c = sc.nextInt();
                sc.nextLine();
                switch (c) {
                    case 1:
                        LearnerTakeQuiz.takeQuiz(learner.id, sc);
                        break;
                    case 2:
                        LearnerViewHistory.viewHistory(learner.id);
                        break;
                    case 3:
                        learnerLoggedIn = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Goodbye!");
        }

        sc.close();
    }
}
