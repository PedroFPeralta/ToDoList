package pt.peralta.todolist.exception;

public class TodoNotFoundException extends RuntimeException {
    
    public TodoNotFoundException(String message) {
        super(message);
    }

    public TodoNotFoundException(){
        super("Todo ID Not Found!!");
    }

}
