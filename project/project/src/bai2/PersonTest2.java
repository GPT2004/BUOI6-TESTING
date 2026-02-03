package bai2;

import org.junit.Test;

public class PersonTest2 {

    @Test(expected = IllegalArgumentException.class)
    public void testExpectedException2() {
        new Person("Fpoly", -1);
    }
}