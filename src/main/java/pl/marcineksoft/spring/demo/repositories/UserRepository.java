package pl.marcineksoft.spring.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.marcineksoft.spring.demo.User;


public interface UserRepository extends JpaRepository<User, Long> {

}