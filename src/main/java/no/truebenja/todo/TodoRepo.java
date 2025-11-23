package no.truebenja.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepo extends JpaRepository<Todo, Integer> {
    List<Todo> findAllByUser(TodoUser user);

    Optional<Todo> findByTodo(String todo);
}
