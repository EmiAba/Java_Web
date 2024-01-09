package com.bonappetit.model.dto;

import com.bonappetit.model.CategoryEnum;

public class MainDishDTO {
    private String name;

    public MainDishDTO(String name, String ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    private String ingredients;

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }
}