package com.example.spring5recipeapp.services;

import com.example.spring5recipeapp.domain.Difficulty;
import com.example.spring5recipeapp.domain.Recipe;
import com.example.spring5recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

    @InjectMocks
    private RecipeServiceImpl recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    private Set<Recipe> recipes = new HashSet<>();

    @BeforeEach
    void setUp() {
        Recipe testRecipe = Recipe.builder().cookTime(10).prepTime(15).difficulty(Difficulty.EASY).description("recipe").build();
        recipes.add(testRecipe);
    }



    @Test
    void getRecipes() {

        when(recipeRepository.findAll()).thenReturn(recipes);
        Set<Recipe> recipeSet = recipeService.getRecipes();

        assertEquals(1, recipeSet.size());
        verify(recipeRepository, times(1)).findAll();
    }
}