package bai4;

import java.util.UUID;

public class AddOrganizationUnitService {

    private final OrganizationUnitDAO dao = new OrganizationUnitDAO();

    public String add(String unitId, String name, String description) {

        if (name == null || name.trim().isEmpty()) {
            return "Name is required";
        }

        if (name.length() > 255) {
            return "Name too long";
        }

        if (description != null && description.length() > 500) {
            return "Description too long";
        }

        if (dao.isNameExists(name)) {
            return "Name already exists";
        }

        if (unitId == null || unitId.isEmpty()) {
            unitId = UUID.randomUUID().toString();
        }

        OrganizationUnit unit =
                new OrganizationUnit(unitId, name.trim(), description);

        dao.insert(unit);
        return "SUCCESS";
    }
}