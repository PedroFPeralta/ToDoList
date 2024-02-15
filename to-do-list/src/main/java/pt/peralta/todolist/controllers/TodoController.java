package pt.peralta.todolist.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pt.peralta.todolist.entity.Todo;
import pt.peralta.todolist.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
    
    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Todo> listAll(){
        return service.listAll();
    }

    @PostMapping
    public ResponseEntity<List<Todo>> create(@Valid @RequestBody Todo todo){
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(service.create(todo));
    }

    @PutMapping("{id}")
    public ResponseEntity<List<Todo>> update(@PathVariable("id") Long id, @RequestBody @Valid Todo todo){
        return ResponseEntity.status(HttpStatus.OK)
            .body(service.update(id,todo));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<Todo>> delete(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK)
            .body(service.delete(id));
        
    }
    

}
