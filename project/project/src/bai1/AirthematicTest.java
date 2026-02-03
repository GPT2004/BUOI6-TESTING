package bai1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AirthematicTest {

    String message = "Fpoly exception";
    JunitMessage junitMessage = new JunitMessage(message);

    // Test bắt ngoại lệ chia cho 0
    @Test(expected = ArithmeticException.class)
    public void testExpectedException() {
        System.out.println("Fpoly Junit Message exception is printing");
        junitMessage.printMessage();
    }

    // Test bình thường
    @Test
    public void testPrintHiMessage() {
        message = "Hi! " + message;
        assertEquals(message, junitMessage.printHiMessage());
    }
}