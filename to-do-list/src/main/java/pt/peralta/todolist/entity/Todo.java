package pt.peralta.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todos")
@Data
@NoArgsConstructor
public class Todo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private boolean done;
    private int priority;

    public Todo(Long id, @NotBlank String name, @NotBlank String description, boolean done, int priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.done = done;
        this.priority = priority;
    }


    public Todo(String name, String description, boolean done, int priority) {
        this.name = name;
        this.description = description;
        this.done = done;
        this.priority = priority;
    }

    
   
    

}
