package recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import recipes.model.Recipe;

import java.util.List;

public interface RecipeRepository  extends JpaRepository<Recipe, Integer> {
    boolean existsById(Integer id);

    List<Recipe> findByCategoryIgnoreCaseOrderByDateDesc(String search);

    @Query("select rc from recipe rc where lower(rc.name) LIKE lower(concat('%', :word, '%'))  order by rc.date DESC ")
    List<Recipe> findByNameIgnoreCaseOrderByDateDesc(@Param("word") String name);
}
