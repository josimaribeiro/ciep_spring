
package br.faetec.com.aula;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("javaVersion", System.getProperty("java.version"));
        model.addAttribute("osName", System.getProperty("os.name"));
        model.addAttribute("horaAtual", LocalDateTime.now());
        return "index"; // corresponde a templates/index.html
    }
}
