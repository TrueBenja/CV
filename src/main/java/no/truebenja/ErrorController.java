package no.truebenja;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/error")
    public String error(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("status", response.getStatus());
        return "error";
    }
}
