package io.github.mac9p.recipeproject.repositories;

import io.github.mac9p.recipeproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {

}
