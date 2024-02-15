package pt.peralta.todolist.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pt.peralta.todolist.entity.Todo;
import pt.peralta.todolist.exception.TodoNotFoundException;
import pt.peralta.todolist.repositories.TodoRepository;

@Service
public class TodoService {
    
    private TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> listAll(){
        // Order by Priority Descend and Name Asc
        Sort sort = Sort.by("priority").descending().and(
            Sort.by("name").ascending()
        );

        return repository.findAll(sort);
    }

    public List<Todo> create(Todo todo){
        repository.save(todo);
        return listAll();
    }

    public List<Todo> update(Long id, Todo todo){
        repository.findById(id).ifPresentOrElse((t) -> {
            todo.setId(id);
            repository.save(todo);
        }, () ->{
            throw new TodoNotFoundException();
        });

        return listAll();
    }

    public List<Todo> delete(Long id){
        repository.findById(id).ifPresentOrElse((t) -> {
            repository.deleteById(id);
        }, () ->{
            throw new TodoNotFoundException();
        });

        return listAll();
    }


}
