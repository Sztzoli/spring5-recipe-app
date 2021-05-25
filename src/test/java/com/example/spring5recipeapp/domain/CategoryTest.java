package com.example.spring5recipeapp.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        category.setId(4l);
        assertEquals(4l, category.getId());
    }

    @Test
    void getDescription() {
        category.setDescription("Cup");
        assertEquals("Cup",category.getDescription());
    }

    @Test
    void getRecipes() {
    }
}