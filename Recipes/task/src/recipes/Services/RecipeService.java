package recipes.Services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import recipes.exceptions.ForbiddenException;
import recipes.exceptions.RecipeNotFoundException;
import recipes.model.Recipe;
import recipes.model.User;
import recipes.repositories.RecipeRepository;
import recipes.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository repository;
    private final UserRepository userRepository ;
    private final Logger LOGGER = LoggerFactory.getLogger(RecipeService.class);


    public RecipeService(RecipeRepository repository, UserRepository userRepository) {
        this.repository = repository;

        this.userRepository = userRepository;
    }


    public List<Recipe> getAllRecipe() {
        return repository.findAll();
    }


    public int  saveRecipe(Recipe recipe) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByEmail(email).get();
        recipe.setDate(LocalDateTime.now());
        recipe.setUser(user);
        repository.save(recipe);
        return recipe.getId();
    }

    public Recipe getRecipeById(int id) throws RecipeNotFoundException {
        Optional<Recipe> recipe = this.repository.findById(id);
        return recipe.orElseThrow(RecipeNotFoundException::new);


    }

    public void updateRecipe(Recipe recipe)  {

        Recipe newRecipe = getRecipeById(recipe.getId());
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!newRecipe.getUser().getEmail().equals(email))
            throw new ForbiddenException();

        newRecipe.setDate(LocalDateTime.now());
        newRecipe.setCategory(recipe.getCategory());
        newRecipe.setDirections(recipe.getDirections());
        newRecipe.setName(recipe.getName());
        newRecipe.setDescription(recipe.getDescription());
        newRecipe.setIngredients(recipe.getIngredients());

        repository.save(newRecipe);

    }

    public void deleteById(int id) throws RecipeNotFoundException {
        Recipe recipe = getRecipeById(id);
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!recipe.getUser().getEmail().equals(email))
            throw new ForbiddenException();
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }


    public List<Recipe> searchCategory(String search) {
        return repository.findByCategoryIgnoreCaseOrderByDateDesc(search);
    }

    public List<Recipe> searchName(String name) {
        return repository.findByNameIgnoreCaseOrderByDateDesc(name);

    }
}
