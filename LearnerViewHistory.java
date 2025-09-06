import java.sql.*;

public class LearnerViewHistory {
    public static void viewHistory(int userId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT t.title, p.score FROM progress p JOIN topics t ON p.topic_id=t.topic_id WHERE user_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n Your Quiz History:");
            while (rs.next()) {
                System.out.println("Topic: " + rs.getString("title") + " | Score: " + rs.getInt("score"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}