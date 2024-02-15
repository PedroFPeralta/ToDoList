package pt.peralta.todolist;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pt.peralta.todolist.exception.BadRequestException;
import pt.peralta.todolist.exception.TodoNotFoundException;

@ControllerAdvice
public class ToDoExceptionsHandler {
    
    @ExceptionHandler(BadRequestException.class)
    private ResponseEntity<Object> handleBadRequest (BadRequestException badRequest){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(badRequest.getMessage());
    } 

    @ExceptionHandler(TodoNotFoundException.class)
    private ResponseEntity<Object> handleTodoNotFound (TodoNotFoundException todoException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(todoException.getMessage());
    }

}
