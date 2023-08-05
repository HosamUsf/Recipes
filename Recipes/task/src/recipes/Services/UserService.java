package recipes.Services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import recipes.exceptions.UserAlreadyExistException;
import recipes.model.User;
import recipes.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository ;
    PasswordEncoder encoder ;

    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }


    public void register(User user ){
        Optional<User> user1 = this.repository.findUserByEmail(user.getEmail());
        if (user1.isPresent())
            throw new UserAlreadyExistException("User with email [%s] already exist" +user.getEmail() );
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return repository.findUserByEmail(email);
    }
}
