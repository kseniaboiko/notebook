package task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByParent(Integer parent);
}
