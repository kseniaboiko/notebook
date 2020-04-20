package task;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Task {

    private @Id @GeneratedValue Integer id;
    @NotBlank
    private String title;
    private Integer parent;
    private Integer priority;
    private Boolean done;

    Task() {}

    public Task(String title, Integer parent,Integer priority,Boolean done) {
        this.title = title;
        this.parent = parent;
        this.priority = priority;
        this.done = done;
    }

}
