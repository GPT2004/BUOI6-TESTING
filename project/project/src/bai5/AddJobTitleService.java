package bai5;

public class AddJobTitleService {

    private final JobTitleDAO dao = new JobTitleDAO();

    public String add(String title, String desc, int fileSizeKb, String note) {

        try {
            if (title == null || title.trim().isEmpty())
                return "Job Title is required";

            if (title.length() > 100)
                return "Job Title too long";

            if (desc != null && desc.length() > 400)
                return "Description too long";

            if (fileSizeKb > 1024)
                return "File too large";

            if (note != null && note.length() > 400)
                return "Note too long";

            if (dao.existsByTitle(title))
                return "Duplicate Job Title";

            dao.insert(title, desc, fileSizeKb, note);
            return "SUCCESS";

        } catch (Exception e) {
            return "Database error";
        }
    }
}