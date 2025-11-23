package no.truebenja.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoUserRepo extends JpaRepository<TodoUser, String> {
}
