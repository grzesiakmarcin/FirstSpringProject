package pl.marcineksoft.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marcineksoft.spring.demo.repositories.UserRepository;



@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final PasswordEncoder encodedPassword;  // gdy nie było final wywalalo blad 500
    // po dodatkowym dopisaniu do konstruktora pod szyldem @Autowired Spring sprawa że nie ma nullpointer exception
    private final UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.encodedPassword=passwordEncoder;
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


        String haselko = encodedPassword.encode(password);// tutaj wywalilo nullpointer'a
        //nullpointerem bylo to co jest przed kropka wiec chodzi o encodedPassword
        // okazalo sie ze mamy braki w konstruktorze
        user.setPassword(haselko);
        user.setActive(true);

       userRepository.save(user);
        System.out.println("Zapisany użytkownik: " + user);


        return "redirect:/home-page.html";
    }




}
