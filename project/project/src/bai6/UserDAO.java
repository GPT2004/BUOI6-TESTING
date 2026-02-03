package bai6;

import java.sql.*;

public class UserDAO {

    public boolean exists(String username) throws Exception {
        String sql = "SELECT 1 FROM users WHERE username = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            return ps.executeQuery().next();
        }
    }

    public void insert(String username, String password, String fullname, String email) throws Exception {
        String sql = "INSERT INTO users(username,password,fullname,email) VALUES (?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setString(4, email);
            ps.executeUpdate();
        }
    }

    public void update(String username, String email) throws Exception {
        String sql = "UPDATE users SET email=? WHERE username=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, username);
            ps.executeUpdate();
        }
    }

    public void delete(String username) throws Exception {
        String sql = "DELETE FROM users WHERE username=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.executeUpdate();
        }
    }

    public void resetPassword(String username, String password) throws Exception {
        String sql = "UPDATE users SET password=? WHERE username=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, password);
            ps.setString(2, username);
            ps.executeUpdate();
        }
    }
}