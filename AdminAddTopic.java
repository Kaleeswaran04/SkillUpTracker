import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AdminAddTopic {
    public static void addTopic(Scanner sc) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Enter new topic title: ");
            String title = sc.nextLine();

            String sql = "INSERT INTO topics(title) VALUES(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.executeUpdate();

            System.out.println(" Topic added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
