package no.truebenja;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TodoUser {
    @Id
    private String username;
    private String hash;
    private String salt;

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
}
