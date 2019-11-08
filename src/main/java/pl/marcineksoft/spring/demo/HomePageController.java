package pl.marcineksoft.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marcineksoft.spring.demo.repositories.AdvertRepository;

import java.util.List;


@Controller
@RequestMapping ("/")
public class HomePageController {


    private final AdvertRepository advertRepository;

    @Autowired
    public HomePageController (AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @GetMapping
    public String prepareHomePage(Model model) {

        List<Advert> allAdverts = advertRepository.findAllByOrderByPostedDesc();

        /*

        żeby List<Advert> allAdverts = advertRepository.findAllByOrderByPostedDesc(); działało musieliśmy zrobić:



    private final AdvertRepository advertRepository;

    @Autowired
    public HomePageController (AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

         */



        model.addAttribute("adverts", allAdverts);
        return "";
    }

}
