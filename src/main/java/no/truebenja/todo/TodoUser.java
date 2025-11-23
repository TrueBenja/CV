package no.truebenja.todo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(schema = "todo")
public class TodoUser {
    @Id
    private String username;
    private String hash;
    private String salt;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Todo> todos;

    public TodoUser() {}

    public TodoUser(String username, String hash, String salt) {
        this.username = username;
        this.hash = hash;
        this.salt = salt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<Todo> getTodos() {
        return todos;
    }
}
