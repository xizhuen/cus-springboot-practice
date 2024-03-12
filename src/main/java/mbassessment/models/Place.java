package mbassessment.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Place {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Place() {
    }

    public Place(String name) {
        this.name = name;
    }

    public Long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
