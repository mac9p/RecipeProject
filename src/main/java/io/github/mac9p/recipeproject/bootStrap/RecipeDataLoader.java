package io.github.mac9p.recipeproject.bootStrap;

import io.github.mac9p.recipeproject.domain.Ingredient;
import io.github.mac9p.recipeproject.domain.Notes;
import io.github.mac9p.recipeproject.domain.Recipe;
import io.github.mac9p.recipeproject.repositories.CategoryRepository;
import io.github.mac9p.recipeproject.repositories.RecipeRepository;
import io.github.mac9p.recipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository measureRepository;
    private final RecipeRepository recipeRepository;

    public RecipeDataLoader(CategoryRepository categoryRepository, UnitOfMeasureRepository measureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.measureRepository = measureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> listOfRecipes = new ArrayList<>(2);


        Recipe guacamole = new Recipe();
        guacamole.getCategories().add(categoryRepository.findByDescription("Mexican").get());
        guacamole.setCookTime(10);
        guacamole.getIngredients().add(new Ingredient("avocado",
                BigDecimal.valueOf(2),
                measureRepository.findByDescription("whole").get()));

        guacamole.getIngredients().add(new Ingredient("salt",
                BigDecimal.valueOf(0.25),
                measureRepository.findByDescription("teaspoon").get()));

        guacamole.getIngredients().add(new Ingredient("lime",
                BigDecimal.valueOf(1),
                measureRepository.findByDescription("tablespoon").get()));

        guacamole.getIngredients().add(new Ingredient("onion",
                BigDecimal.valueOf(2),
                measureRepository.findByDescription("tablespoon").get()));

        guacamole.getIngredients().add(new Ingredient("chilli",
                BigDecimal.valueOf(2),
                measureRepository.findByDescription("whole").get()));

        guacamole.getIngredients().add(new Ingredient("cilantro",
                BigDecimal.valueOf(2),
                measureRepository.findByDescription("tablespoon").get()));

        guacamole.getIngredients().add(new Ingredient("pepper",
                BigDecimal.valueOf(1),
                measureRepository.findByDescription("pinch").get()));
        guacamole.setNotes(new Notes(guacamoleNotes));
        guacamole.setDirections(guacamoleDirections);
        listOfRecipes.add(guacamole);


        return listOfRecipes;
    }

    private final String guacamoleNotes = "Be careful handling chilis! If using," +
            " it's best to wear food-safe gloves." +
            " If no gloves are available," +
            " wash your hands thoroughly after handling," +
            " and do not touch your eyes or the area near your eyes for several hours afterwards.";
    private final String guacamoleDirections = "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
            "\n" +
            "How to make guacamole - scoring avocado\n" +
            "Mash the avocado flesh:\n" +
            "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
            "\n" +
            "How to make guacamole - smashing avocado with fork\n" +
            "Add remaining ingredients to taste:\n" +
            "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
            "\n" +
            "Add the chopped onion, cilantro, black pepper, and chilis. Chili peppers vary individually in their spiciness. So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.\n" +
            "\n" +
            "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
            "\n" +
            "Serve immediately:\n" +
            "If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)\n" +
            "\n" +
            "Garnish with slices of red radish or jigama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips.\n" +
            "\n" +
            "Refrigerate leftover guacamole up to 3 days.\n" +
            "\n" +
            "Note: Chilling tomatoes hurts their flavor. So, if you want to add chopped tomato to your guacamole, add it just before serving.";
}
