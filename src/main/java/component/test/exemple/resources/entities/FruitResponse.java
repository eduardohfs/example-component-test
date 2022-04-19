package component.test.exemple.resources.entities;

public class FruitResponse {
    private String familyName;

    public FruitResponse(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
