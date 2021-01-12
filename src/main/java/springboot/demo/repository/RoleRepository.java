package springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.demo.entity.Role;


public interface RoleRepository extends JpaRepository<Role,Long> {

}