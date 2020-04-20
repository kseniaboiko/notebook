package task;

class TaskNotFoundException extends RuntimeException {

    TaskNotFoundException(Integer id) {
        super("Could not find task " + id);
    }
}
