package recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import recipes.model.Recipe;
import recipes.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


//    @Query("""
//        select u from User u where u.email =: email
//        """)
    Optional<User> findUserByEmail(String email);


}
