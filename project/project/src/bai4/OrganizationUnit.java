package bai4;

public class OrganizationUnit {
    private String unitId;
    private String name;
    private String description;

    public OrganizationUnit(String unitId, String name, String description) {
        this.unitId = unitId;
        this.name = name;
        this.description = description;
    }

    public String getUnitId() {
        return unitId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}