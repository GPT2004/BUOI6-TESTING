package bai5;

import static org.junit.Assert.*;
import org.junit.Test;

public class AddJobTitleTest {

    AddJobTitleService service = new AddJobTitleService();

    // TC01
    @Test
    public void TC01_titleEmpty() {
        assertEquals("Job Title is required",
                service.add("", "", 0, ""));
    }

    // TC02
    @Test
    public void TC02_titleValid() {
        assertEquals("SUCCESS",
                service.add("Developer", "", 0, ""));
    }

    // TC03
    @Test
    public void TC03_titleSpaces() {
        assertEquals("Job Title is required",
                service.add("   ", "", 0, ""));
    }

    // TC04
    @Test
    public void TC04_title100Chars() {
        String t = "A".repeat(100);
        assertEquals("SUCCESS",
                service.add(t, "", 0, ""));
    }

    // TC05
    @Test
    public void TC05_titleTooLong() {
        String t = "A".repeat(101);
        assertEquals("Job Title too long",
                service.add(t, "", 0, ""));
    }

    // TC06
    @Test
    public void TC06_descEmpty() {
        assertEquals("SUCCESS",
                service.add("Tester", "", 0, ""));
    }

    // TC07
    @Test
    public void TC07_descTooLong() {
        String d = "D".repeat(401);
        assertEquals("Description too long",
                service.add("QA", d, 0, ""));
    }

    // TC08
    @Test
    public void TC08_noFile() {
        assertEquals("SUCCESS",
                service.add("BA", "", 0, ""));
    }

    // TC09
    @Test
    public void TC09_fileValid() {
        assertEquals("SUCCESS",
                service.add("PO", "", 1024, ""));
    }

    // TC10
    @Test
    public void TC10_fileTooLarge() {
        assertEquals("File too large",
                service.add("PM", "", 1025, ""));
    }

    // TC11 – FAIL có chủ đích (trùng dữ liệu)
    @Test
    public void TC11_duplicateTitle_shouldFail() {
        service.add("HR", "", 0, "");
        String result = service.add("HR", "", 0, "");
        assertEquals("Duplicate Job Title", result);
    }

    // TC12 – FAIL có chủ đích (lỗi DB)
    @Test
    public void TC12_systemError_shouldFail() {
        String result = "Database error"; // giả lập
        assertEquals("Detailed DB error", result);
    }
}