package no.truebenja.todo;

import jakarta.persistence.*;

@Entity
@Table(schema = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String todo;

    @ManyToOne
    @JoinColumn(name = "username")
    private TodoUser user;


    public Todo() {}

    public Todo(String todo, TodoUser user) {
        this.todo = todo;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public TodoUser getUser() {
        return user;
    }

    public void setUser(TodoUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return todo;
    }
}
