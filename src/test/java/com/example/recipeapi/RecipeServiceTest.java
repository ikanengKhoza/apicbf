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
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)

//1. start by creating a test class
class RecipeServiceTest {

    @Mock //used a replacement for a dependency
    private RecipeRepository recipeRepository; //tested and works as expected

    //2.
    private RecipeService underTest;


    //3.set up
    //before each test we get a fresh instance for recipe service
    @BeforeEach
    void setUp() {
        underTest = new RecipeService(recipeRepository);
    }



    @Test
    void canSaveARecipe() {
        //given
        Recipe recipe = new Recipe(
                "Blackberry pie",
                List.of(
                        new Ingredients("blackberries", "600g"),
                        new Ingredients("self-raising flour", "300g (plus extra for dusting)")),
                "First, make the pastry. Tip both flours and the sugar into a bowl with a large pinch of salt..."
        );
        //when
        underTest.save(recipe);

        //then
        //we need an ArgumentCaptOR. ArgumentCaptor allows us to capture an argument passed to a method
        ArgumentCaptor<Recipe> recipeArgumentCaptor = ArgumentCaptor.forClass(Recipe.class);

        verify(recipeRepository).save(recipeArgumentCaptor.capture());

        Recipe capturedRecipe = recipeArgumentCaptor.getValue();

        assertThat(capturedRecipe).isEqualTo(recipe);
    }

    // we don't want to test the real recipe Repository because we already know that all the methods work, unit test becomes fast



    @Test
    void canFindTheListOfAllRecipes() {
        underTest.findAllRecipes();
        verify(recipeRepository).findAll();
    }

}