package no.truebenja;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {
    @Autowired
    TodoLoginService todoLoginService;

    @Autowired
    PasswordService passwordService;

    @GetMapping("/todo")
    public String todo(Model model, HttpServletRequest request, RedirectAttributes ra) {
        if (!todoLoginService.isLoggedIn(request.getSession())) {
            return "redirect:todo-login";
        }

        model.addAttribute("todos", request.getSession().getAttribute("todos"));
        return "todo";
    }

    @GetMapping("/todo-register")
    public String register(Model model) {
        return "register";
    }

    @PostMapping("/todo-register")
    public String register(String username, String password, RedirectAttributes ra) {
        return "redirect:todo-login";
    }

    @GetMapping("/todo-login")
    public String login(HttpServletRequest request) {
        if (todoLoginService.isLoggedIn(request.getSession())) {
            return "redirect:todo";
        }

        return "login";
    }

    @PostMapping("/todo-login")
    public String login(HttpServletRequest request, String username, String password, RedirectAttributes ra) {
        if (username.isEmpty() || password.isEmpty()) {
            ra.addFlashAttribute("message", "Username or password is empty");
            return "redirect:todo-login";
        }

        todoLoginService.login(request, username);
        return "redirect:todo";
    }

    @PostMapping("/add-todo")
    public String addTodo(HttpServletRequest request, String todo) {
        if (!todoLoginService.isLoggedIn(request.getSession())) {
            return "redirect:todo-login";
        }

        List<String> items = (ArrayList<String>) request.getSession().getAttribute("todos");
        if (!todo.trim().isEmpty()) {
            items.add(todo);
        }

        return "redirect:todo";
    }

    @PostMapping("remove-todos")
    public String removeTodo(HttpServletRequest request, String[] todos) {
        if (!todoLoginService.isLoggedIn(request.getSession())) {
            return "redirect:todo-login";
        }

        List<String> items = (ArrayList<String>) request.getSession().getAttribute("todos");

        if (todos != null) {
            for (String todo : todos) {
                items.remove(todo);
            }
        }

        return "redirect:todo";
    }

    @PostMapping("todo-logout")
    public String logout(HttpServletRequest request) {
        todoLoginService.logout(request.getSession());
        return "redirect:todo-login";
    }
}
