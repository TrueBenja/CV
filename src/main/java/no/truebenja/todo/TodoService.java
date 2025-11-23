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

    /**
     * @param username The username you wish to check if exists
     * @return True if user already exists in the database
     */
    public boolean checkIfExists(String username) {
        return todoUserRepo.existsById(username);
    }

    /**
     * @param todoUser The TodoUser to register
     */
    public void registerUser(TodoUser todoUser) {
        todoUserRepo.save(todoUser);
    }

    /**
     * @param username The username to search
     * @return The TodoUser if found, null if not found
     */
    public TodoUser findUserByUsername(String username) {
        return todoUserRepo.findById(username).orElse(null);
    }

    /**
     * @param todo The name/description of the todo
     * @return The Todo if found, null if not found
     */
    public Todo findTodoByName(String todo) {
        return todoRepo.findByTodo(todo).orElse(null);
    }

    public void saveTodo(Todo todo) {
        todoRepo.save(todo);
    }

    public void removeTodo(Todo todo) {
        todoRepo.delete(todo);
    }
}
