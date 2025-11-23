package no.truebenja.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoUserRepo todoUserRepo;

    @Autowired
    TodoRepo  todoRepo;

    public boolean checkIfExists(String username) {
        return todoUserRepo.existsById(username);
    }

    public void registerUser(TodoUser todoUser) {
        todoUserRepo.save(todoUser);
    }

    public TodoUser findUserByUsername(String username) {
        return todoUserRepo.findById(username).orElse(null);
    }

    public Todo findTodoByName(String todo) {
        return todoRepo.findByTodo(todo).orElse(null);
    }

    public void saveTodo(Todo todo) {
        todoRepo.save(todo);
    }

    public void removeTodo(Todo todo) {
        todoRepo.delete(todo);
    }

    public List<Todo> getTodos(TodoUser todoUser) {
        return todoRepo.findAllByUser(todoUser);
    }
}
