package bai6;

public class UserService {

    private final UserDAO dao = new UserDAO();

    public String create(String username, String password, String email) {
        try {
            if (username == null || username.trim().isEmpty())
                return "Username is required";

            if (dao.exists(username))
                return "Username already exists";

            if (password == null || password.length() < 6)
                return "Password too short";

            if (email == null || !email.contains("@"))
                return "Invalid email";

            dao.insert(username, password, null, email);
            return "SUCCESS";

        } catch (Exception e) {
            return "Database error";
        }
    }

    public String update(String username, String email) {
        try {
            if (!dao.exists(username))
                return "User not found";

            if (email == null || !email.contains("@"))
                return "Invalid email";

            dao.update(username, email);
            return "SUCCESS";

        } catch (Exception e) {
            return "Database error";
        }
    }

    public String delete(String username) {
        try {
            if (!dao.exists(username))
                return "User not found";

            dao.delete(username);
            return "SUCCESS";

        } catch (Exception e) {
            return "Database error";
        }
    }

    public String resetPassword(String username, String password) {
        try {
            if (!dao.exists(username))
                return "User not found";

            if (password == null || password.length() < 6)
                return "Password too short";

            dao.resetPassword(username, password);
            return "SUCCESS";

        } catch (Exception e) {
            return "Database error";
        }
    }
}