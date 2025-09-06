public class Admin extends User {
    public Admin(int id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void showDashboard() {
        System.out.println("\n=== Admin Dashboard ===");
        System.out.println("1. Add Topic");
        System.out.println("2. View Stats");
        System.out.println("3. Logout");
    }
}
