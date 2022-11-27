package com.example.recipeapi;

import com.example.recipeapi.Model.Recipe;
import com.example.recipeapi.Repository.IngredientsRepository;
import com.example.recipeapi.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private IngredientsRepository ingredientsRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientsRepository = ingredientsRepository;
    }

    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll();
    }


    public Recipe updateRecipe(Recipe recipe) {
        Recipe existingRecipe = recipeRepository.findById(recipe.getId()).orElseThrow();
        existingRecipe.setId(recipe.getId());
        existingRecipe.setName(recipe.getName());
        existingRecipe.setIngredients(recipe.getIngredients());
        existingRecipe.setDescription(recipe.getDescription());
        existingRecipe.setInstructions(recipe.getInstructions());
        return recipeRepository.save(existingRecipe);
    }
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }
}