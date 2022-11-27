package com.example.recipeapi;


import com.example.recipeapi.Model.Ingredients;
import com.example.recipeapi.Model.Recipe;
import com.example.recipeapi.Repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {

    @Mock
    private RecipeRepository recipeRepository;
    private RecipeService underTest;


    @BeforeEach
    void setUp() {
        underTest = new RecipeService(recipeRepository);
    }


    @Test
    void saveARecipe() {
        Recipe recipe = new Recipe(
                "Blackberry pie",
                List.of(
                        new Ingredients("blackberries", "600g"),
                        new Ingredients("self-raising flour", "300g (plus extra for dusting)")),
                "First, make the pastry. Tip both flours and the sugar into a bowl with a large pinch of salt..."
        );
        underTest.save(recipe);

        ArgumentCaptor<Recipe> recipeArgumentCaptor = ArgumentCaptor.forClass(Recipe.class);

        verify(recipeRepository).save(recipeArgumentCaptor.capture());

        Recipe capturedRecipe = recipeArgumentCaptor.getValue();

        assertThat(capturedRecipe).isEqualTo(recipe);
    }

    @Test
    void canFindAllRecipes() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void updateRecipe() {
    }
}