package pl.olointeria.spring_08_mysql_company.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
class HomeController {

    @GetMapping("/")
    String home() {
        return "index";
    }
}
