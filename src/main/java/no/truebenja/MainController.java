package no.truebenja;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(@CookieValue(name = "visitedBefore", required = false) Optional<String> visitedBefore, Model model, HttpServletResponse response) {
        visitedBefore.ifPresentOrElse(c -> {
            model.addAttribute("visitedBefore", "Velkommen tilbake :)");
        }, () -> {
            Cookie c = new Cookie("visitedBefore", "true");
            c.setMaxAge(3600);
            response.addCookie(c);
        });

        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
