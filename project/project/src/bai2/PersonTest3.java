package bai2;

import static org.junit.Assert.fail;
import org.junit.Test;

public class PersonTest3 {

    @Test
    public void testExpectedException3() {
        try {
            new Person("Fpoly", -1);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Test pass
        }
    }
}