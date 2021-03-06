package springboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.demo.entity.User;
import springboot.demo.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
   @PersistenceContext
   private EntityManager em;

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService() {
    }

    public void addUser(User user)  {
        userRepository.save(user);
    }

    public void removeUser(User user)  {
        userRepository.delete(user);
    }

    public void updateUser(User user)  {
        userRepository.save(user);
    }


    public List<User> getAllUsers()  {
        return userRepository.findAll();
    }

    public User getUserById(long id)  {
        User user = null;
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            user = optional.get();
        }
        return user;
    }


    public boolean checkLastName(String lastName)  {
        return userRepository.existsDistinctByLastName(lastName);
    }

}
