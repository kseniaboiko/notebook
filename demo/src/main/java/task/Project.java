package task;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Project {

    private @Id @GeneratedValue Integer idProject;
    @NotBlank
    private String name;

    Project() {}

    public Project(String name) {
        this.name = name;
    }
}
