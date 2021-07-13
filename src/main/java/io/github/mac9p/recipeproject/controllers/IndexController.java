package io.github.mac9p.recipeproject.controllers;

import io.github.mac9p.recipeproject.domain.Category;
import io.github.mac9p.recipeproject.domain.UnitOfMeasure;
import io.github.mac9p.recipeproject.repositories.CategoryRepository;
import io.github.mac9p.recipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){

        /*Optional<Category> categoryOptional = categoryRepository.findByDescription("Polish");
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("cup");

        System.out.println("Cat Id is:" + categoryOptional.get().getId());
        System.out.println("Uom Id is:" + optionalUnitOfMeasure.get().getId());*/
        return "index";

    }
}
