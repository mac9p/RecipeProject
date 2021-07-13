package io.github.mac9p.recipeproject.repositories;

import io.github.mac9p.recipeproject.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CategoryRepository extends CrudRepository<Category,Long> {
    Optional<Category> findByDescription(String description);
}
