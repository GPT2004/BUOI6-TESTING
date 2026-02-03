package bai4;

import java.util.HashSet;
import java.util.Set;

public class OrganizationUnitDAO {

    private static final Set<String> names = new HashSet<>();

    public boolean isNameExists(String name) {
        return names.contains(name.toLowerCase());
    }

    public void insert(OrganizationUnit unit) {
        names.add(unit.getName().toLowerCase());
    }
}