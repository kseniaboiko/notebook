package task;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
    private final ProjectRepository repository;
    ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/project")
    List<Project> all() {
        return repository.findAll();
    }

    @PostMapping("/project")
    Project newProject(@RequestBody Project newProject) {
        return repository.save(newProject);
    }

    // Single item

    @GetMapping("/project/{idProject}")
    Project one(@PathVariable Integer idProject) {
        return repository.findById(idProject)
                .orElseThrow(() -> new ProjectNotFoundException(idProject));
    }

    @PutMapping("/project/{idProject}")
    Project replaceProject(@RequestBody Project newProject, @PathVariable Integer idProject) {

        return repository.findById(idProject)
                .map(project -> {
                    project.setName(newProject.getName());
                    return repository.save(project);
                })
                .orElseGet(() -> {
                    newProject.setIdProject(idProject);
                    return repository.save(newProject);
                });
    }

    @DeleteMapping("/project/{idProject}")
    void deleteProject(@PathVariable Integer idProject) {
        repository.deleteById(idProject);
    }

}
