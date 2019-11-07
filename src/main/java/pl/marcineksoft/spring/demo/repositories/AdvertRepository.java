package pl.marcineksoft.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.marcineksoft.spring.demo.Advert;

public interface AdvertRepository extends JpaRepository<Advert, Long> {

}
