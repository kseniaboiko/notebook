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
class TaskController {

    private final TaskRepository repository;
    TaskController(TaskRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/task")
    List<Task> all() {
        return repository.findAll();
    }

    @PostMapping("/task")
    Task newTask(@RequestBody Task newTask) {
        return repository.save(newTask);
    }

    // Single item

    @GetMapping("/task/{id}")
    Task one(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @GetMapping("/task/project/{parent}")
    List<Task> oneProject(@PathVariable Integer parent) {
        return repository.findByParent(parent);
    }

    @PutMapping("/task/{id}")
    Task replaceTask(@RequestBody Task newTask, @PathVariable Integer id) {

        return repository.findById(id)
                .map(task -> {
                    task.setTitle(newTask.getTitle());
                    task.setParent(newTask.getParent());
                    task.setPriority(newTask.getPriority());
                    task.setDone(newTask.getDone());
                    return repository.save(task);
                })
                .orElseGet(() -> {
                    newTask.setId(id);
                    return repository.save(newTask);
                });
    }

    @DeleteMapping("/task/{id}")
    void deleteTask(@PathVariable Integer id) {
        repository.deleteById(id);
    }



}
