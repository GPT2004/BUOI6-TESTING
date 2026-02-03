package bai5;

import java.sql.*;

public class JobTitleDAO {

    public boolean existsByTitle(String title) throws Exception {
        String sql = "SELECT 1 FROM job_title WHERE title = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, title);
            return ps.executeQuery().next();
        }
    }

    public void insert(String title, String desc, int fileSize, String note) throws Exception {
        String sql = "INSERT INTO job_title(title, description, file_size_kb, note) VALUES (?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, desc);
            ps.setInt(3, fileSize);
            ps.setString(4, note);
            ps.executeUpdate();
        }
    }
}