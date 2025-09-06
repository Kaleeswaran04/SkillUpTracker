import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminViewStats {
    public static void viewStats() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT t.title, COUNT(*) AS attempts, AVG(score) AS avg_score " +
                    "FROM progress p JOIN topics t ON p.topic_id = t.topic_id GROUP BY t.title";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n Quiz Statistics:");
            while (rs.next()) {
                String title = rs.getString("title");
                int attempts = rs.getInt("attempts");
                double avgScore = rs.getDouble("avg_score");
                System.out.println("Topic: " + title + " | Attempts: " + attempts + " | Average Score: " + avgScore);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}