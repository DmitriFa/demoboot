package springboot.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import springboot.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLastName(String lastName);

    boolean existsDistinctByLastName(String lastname);



}

