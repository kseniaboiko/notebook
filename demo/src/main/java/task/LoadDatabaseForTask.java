package task;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabaseForTask {

    @Bean
    CommandLineRunner initDatabase(TaskRepository repository, ProjectRepository repository1) {
        return args -> {
            log.info("Preloading " + repository1.save(new Project("Open")));
            log.info("Preloading " + repository.save(new Task("Open", 1, 1, true )));


        };
    }


}

