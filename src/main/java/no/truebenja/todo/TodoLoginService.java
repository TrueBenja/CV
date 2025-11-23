package no.truebenja.todo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class TodoLoginService {
    public void logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
    }

    public void login(HttpServletRequest request, String username) {
        logout(request.getSession());

        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setMaxInactiveInterval(3600);
    }

    public boolean isLoggedIn(HttpSession session) {
        return session != null && session.getAttribute("username") != null;
    }

    public boolean isValidCredentials(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (!username.matches("^\\w{4,25}$")) {
            return false;
        }

        return password.matches("^\\w{12,}$");
    }
}
