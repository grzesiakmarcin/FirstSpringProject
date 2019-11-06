package pl.marcineksoft.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marcineksoft.spring.demo.repositories.UserRepository;



@Controller
@RequestMapping("/register")
public class RegistrationController {


    private final UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @GetMapping
    public String prepareRegistrationPage(){
        return "/WEB-INF/views/registration-form.jsp";}


        //gdybysmy mieli tutaj put dochodzilo by do update tych wartosci !!!!!.
    @PostMapping // post tworzy nam nowego użytkownika
    public String procesRegistrationPage(String username,
                                         String password,
                                         String firstName,
                                         String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        user.setActive(true);


        return "";
    }


}
