package recipes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.Services.RecipeService;
import recipes.exceptions.RecipeNotFoundException;
import recipes.model.Recipe;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/recipe")
public class RecipeController {

    private final RecipeService service ;


    public RecipeController(RecipeService service) {
        this.service = service;
    }



    @GetMapping
    public List<Recipe> getRecipeById()  {

        return service.getAllRecipe();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable int id) throws RecipeNotFoundException {

        return service.getRecipeById(id);
    }

    @GetMapping("search")
    public ResponseEntity<?> searchRecipe(@RequestParam(value = "category", required = false) String category,
                                     @RequestParam(value = "name", required = false) String name){
        List<Recipe> recipes = new ArrayList<>();
        if (category != null) {
            recipes =  service.searchCategory(category);
        } else if (name != null) {
            recipes = service.searchName(name);
        } else {
            return new ResponseEntity<>(recipes,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(recipes,HttpStatus.OK);

    }


    @PostMapping("/new")
    public ResponseEntity<?> saveRecipe(@Valid @RequestBody Recipe recipe){
//        service.saveRecipe(recipe);
        return new ResponseEntity<>(Map.of("id" , service.saveRecipe(recipe)) , HttpStatus.OK) ;
    }


//    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping("/{id}" )
    public ResponseEntity<?> updateRecipe(@PathVariable("id") int id ,@Valid @RequestBody Recipe recipe) {
        recipe.setId(id);
        service.updateRecipe(recipe);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping()
    public ResponseEntity<?> deleteAll (){
        service.deleteAll();
        return new ResponseEntity<>(Map.of("done" ,"allDeleted"),HttpStatus.BAD_GATEWAY);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable int id ) throws RecipeNotFoundException {
        service.deleteById(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

}
