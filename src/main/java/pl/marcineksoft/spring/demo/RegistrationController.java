package pl.marcineksoft.spring.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    public String prepareRegistrationPage(){
        return "/WEB-INF/views/registration-form.jsp";}

    @PostMapping
    public String procesRegistrationPage(){
        return "";
    }


}
