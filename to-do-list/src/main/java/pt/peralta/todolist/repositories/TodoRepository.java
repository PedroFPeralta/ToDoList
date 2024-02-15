package pt.peralta.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.peralta.todolist.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
