import java.sql.*;
import java.util.Scanner;

public class LearnerTakeQuiz {
    public static void takeQuiz(int userId, Scanner sc) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Enter topic ID to attempt quiz: ");
            int topicId = sc.nextInt();
            sc.nextLine();

            String sql = "SELECT * FROM quizzes WHERE topic_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, topicId);
            ResultSet rs = stmt.executeQuery();

            int score = 0;
            while (rs.next()) {
                System.out.println("\n" + rs.getString("question"));
                System.out.println("A) " + rs.getString("option_a"));
                System.out.println("B) " + rs.getString("option_b"));
                System.out.println("C) " + rs.getString("option_c"));
                System.out.println("D) " + rs.getString("option_d"));
                System.out.print("Your answer (A/B/C/D): ");
                String ans = sc.nextLine().toUpperCase();

                if (ans.equals(rs.getString("correct_option"))) score++;
            }
            System.out.println("\n Quiz finished! You scored: " + score);

            PreparedStatement save = conn.prepareStatement(
                "INSERT INTO progress(user_id, topic_id, score) VALUES (?, ?, ?)");
            save.setInt(1, userId);
            save.setInt(2, topicId);
            save.setInt(3, score);
            save.executeUpdate();

            System.out.println("Score saved to your history.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}