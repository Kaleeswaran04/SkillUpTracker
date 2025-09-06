public class Learner extends User {
    public Learner(int id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void showDashboard() {
        System.out.println("\n=== Learner Dashboard ===");
        System.out.println("1. Take Quiz");
        System.out.println("2. View History");
        System.out.println("3. Logout");
    }
}