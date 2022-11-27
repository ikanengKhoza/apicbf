package com.example.recipeapi.Controller;


import com.example.recipeapi.Model.Recipe;
import com.example.recipeapi.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "recipes")
@CrossOrigin(origins = "http://localhost:3000")
public class RecipeController {


    private final RecipeService recipeService;
    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping
    public List<Recipe> findAllRecipes() {
        return recipeService.findAllRecipes();

    }

    @PostMapping
    public Recipe saveRecipe(@RequestBody Recipe recipe) {
        return recipeService.save(recipe);
    }


    @PutMapping(path = "update/{recipeId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        return recipeService.updateRecipe(recipe);

    }

    @DeleteMapping(path = "{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") Long recipeId) {
        recipeService.deleteById(recipeId);
    }


}
