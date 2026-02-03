package bai4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AddOrganizationUnitTest {

    private AddOrganizationUnitService service;

    @Before
    public void setUp() {
        service = new AddOrganizationUnitService();
    }

    @Test
    public void TC01_addValid() {
        String result = service.add("", "IT", "Info Tech");
        assertEquals("SUCCESS", result);
    }

    @Test
    public void TC02_nameEmpty() {
        String result = service.add("", "", "Desc");
        assertEquals("Name is required", result);
    }

    @Test
    public void TC03_nameSpaces() {
        String result = service.add("", "   ", "Desc");
        assertEquals("Name is required", result);
    }

    @Test
    public void TC04_nameTooLong() {
        String longName = "A".repeat(256);
        String result = service.add("", longName, "Desc");
        assertEquals("Name too long", result);
    }

    @Test
    public void TC05_nameDuplicate() {
        service.add("", "HR", "Human Resource");
        String result = service.add("", "HR", "Human Resource");
        assertEquals("Name already exists", result);
    }

    @Test
    public void TC06_descEmpty() {
        String result = service.add("", "Finance", "");
        assertEquals("SUCCESS", result);
    }

    @Test
    public void TC07_descTooLong() {
        String longDesc = "D".repeat(501);
        String result = service.add("", "Legal", longDesc);
        assertEquals("Description too long", result);
    }

    @Test
    public void TC08_unitIdEmpty_shouldFail() {
    String result = service.add("", "QA", "Quality");

    assertEquals("Unit Id is required", result);
}

    @Test
    public void TC09_unitIdValid() {
        String result = service.add("OU01", "Ops", "Operation");
        assertEquals("SUCCESS", result);
    }


    @Test
    public void TC11_saveTwice() {
        service.add("", "Dev", "Developer");
        String result = service.add("", "Dev", "Developer");
        assertEquals("Name already exists", result);
    }

    
    @Test
    public void TC12_systemError_shouldFail() {
    String result = "Database error"; 

    assertEquals("Database connection timeout", result);
}
}