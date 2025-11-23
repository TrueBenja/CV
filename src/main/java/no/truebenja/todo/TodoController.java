package no.truebenja.todo;

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

    @Autowired
    TodoService todoService;

    @GetMapping("/todo")
    public String todo(Model model, HttpServletRequest request, RedirectAttributes ra) {
        if (!todoLoginService.isLoggedIn(request.getSession())) {
            return "redirect:todo-login";
        }

        List<Todo> todos = todoService.findUserByUsername((String) request.getSession().getAttribute("username")).getTodos();

        model.addAttribute("todos", todos);
        return "todo";
    }

    @GetMapping("/todo-register")
    public String register(Model model) {
        return "register";
    }

    @PostMapping("/todo-register")
    public String register(String username, String password, RedirectAttributes ra) {
        if (todoService.checkIfExists(username)) {
            ra.addFlashAttribute("message", "User with that username already exists");
            return "redirect:todo-register";
        }

        if (!todoLoginService.isValidCredentials(username, password)) {
            ra.addFlashAttribute("message", "Invalid credentials");
            return "redirect:todo-register";
        }

        String salt = passwordService.generateRandomSalt();
        String hash = passwordService.hashWithSalt(password, salt);

        TodoUser  todoUser = new TodoUser(username, hash, salt);
        todoService.registerUser(todoUser);

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

        TodoUser todoUser = todoService.findUserByUsername(username);

        if (todoUser == null || !passwordService.checkPassword(password, todoUser.getHash(), todoUser.getSalt())) {
            ra.addFlashAttribute("message", "Invalid username and/or password!");
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

        // List<String> items = (ArrayList<String>) request.getSession().getAttribute("todos");

        TodoUser user = todoService.findUserByUsername((String) request.getSession().getAttribute("username"));

        List<Todo> items = user.getTodos();

        Todo newTodo = new Todo(todo, user);

        if (!todo.trim().isEmpty()) {
            //items.add(newTodo);
            todoService.saveTodo(newTodo);
        }

        return "redirect:todo";
    }

    @PostMapping("remove-todos")
    public String removeTodo(HttpServletRequest request, String[] todos) {
        if (!todoLoginService.isLoggedIn(request.getSession())) {
            return "redirect:todo-login";
        }

        // List<String> items = (ArrayList<String>) request.getSession().getAttribute("todos");

        for (String todo : todos) {
            Todo todoToDelete = todoService.findTodoByName(todo);
            todoService.removeTodo(todoToDelete);
        }

        return "redirect:todo";
    }

    @PostMapping("todo-logout")
    public String logout(HttpServletRequest request) {
        todoLoginService.logout(request.getSession());
        return "redirect:todo-login";
    }
}
