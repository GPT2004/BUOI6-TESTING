package bai6;

import static org.junit.Assert.*;
import org.junit.Test;

public class UserServiceTest {

    UserService service = new UserService();

    @Test
    public void TC01_usernameEmpty() {
        assertEquals("Username is required",
                service.create("", "123456", "a@gmail.com"));
    }

    @Test
    public void TC02_createValid() {
        assertEquals("SUCCESS",
                service.create("admin", "123456", "admin@gmail.com"));
    }

    @Test
    public void TC03_duplicateUsername() {
        service.create("user1", "123456", "u1@gmail.com");
        assertEquals("Username already exists",
                service.create("user1", "123456", "u1@gmail.com"));
    }

    @Test
    public void TC04_passwordTooShort() {
        assertEquals("Password too short",
                service.create("user2", "123", "u2@gmail.com"));
    }

    @Test
    public void TC05_invalidEmail() {
        assertEquals("Invalid email",
                service.create("user3", "123456", "email"));
    }

    @Test
    public void TC06_updateValid() {
        service.create("user4", "123456", "u4@gmail.com");
        assertEquals("SUCCESS",
                service.update("user4", "new@gmail.com"));
    }

    @Test
    public void TC07_updateNotFound_shouldFail() {
        assertEquals("SUCCESS",
                service.update("ghost", "a@gmail.com"));
    }

    @Test
    public void TC08_deleteValid() {
        service.create("user5", "123456", "u5@gmail.com");
        assertEquals("SUCCESS",
                service.delete("user5"));
    }

    @Test
    public void TC09_deleteNotFound_shouldFail() {
        assertEquals("SUCCESS",
                service.delete("ghost"));
    }

    @Test
    public void TC10_resetPasswordTooShort_shouldFail() {
        service.create("user6", "123456", "u6@gmail.com");
        assertEquals("SUCCESS",
                service.resetPassword("user6", "123"));
    }
}