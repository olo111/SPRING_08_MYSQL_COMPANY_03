package pl.olointeria.spring_08_mysql_company.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {

    @GetMapping("/login")
    String loginForm() {
        return "login-form";
    }
}
