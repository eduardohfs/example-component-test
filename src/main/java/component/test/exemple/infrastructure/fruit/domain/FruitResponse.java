package component.test.exemple.infrastructure.fruit.domain;

import javax.json.bind.annotation.JsonbProperty;

public class FruitResponse {
    private String family;
    private String genus;
    private Long id;
    private String name;

    @JsonbProperty("Nutritions")
    private NutritionsResponse nutritionsResponse;

    private String order;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NutritionsResponse getNutritions() {
        return nutritionsResponse;
    }

    public void setNutritions(NutritionsResponse nutritionsResponse) {
        this.nutritionsResponse = nutritionsResponse;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "FruitResponse{" +
                "family='" + family + '\'' +
                ", genus='" + genus + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", nutritions=" + nutritionsResponse +
                ", order='" + order + '\'' +
                '}';
    }
}
