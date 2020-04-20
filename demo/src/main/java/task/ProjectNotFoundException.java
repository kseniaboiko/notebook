package task;

class ProjectNotFoundException extends RuntimeException {

    ProjectNotFoundException(Integer idProject) {
        super("Could not find project " + idProject);
    }
}
