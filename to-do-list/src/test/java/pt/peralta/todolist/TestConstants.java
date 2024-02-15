package pt.peralta.todolist;

import java.util.ArrayList;
import java.util.List;

import pt.peralta.todolist.entity.Todo;

public class TestConstants {
    public static final List<Todo> TODOS = new ArrayList<>() {
    {
      add(new Todo(100L, "PeraltaPedro", "Força", true, 1));
      add(new Todo(101L, "PeraltaPedro", "Foco", true, 1));
      add(new Todo(102L, "PeraltaPedro", "Fe", true, 1));
      add(new Todo(103L, "PeraltaPedro", "Respect", false, 1));
      add(new Todo(104L, "PeraltaPedro", "Proud", false, 1));
    }
  };

  public static final Todo TODO = TODOS.get(0);
}
