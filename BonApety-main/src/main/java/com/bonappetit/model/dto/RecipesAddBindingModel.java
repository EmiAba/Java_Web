package com.bonappetit.model.dto;

import com.bonappetit.model.CategoryEnum;
import com.bonappetit.model.entity.Category;
import com.bonappetit.model.entity.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RecipesAddBindingModel {
    @Size(min = 2, max = 50, message="Name length should be between 2 and 40 characters!")
    private String name;
    @Size(min = 2, max = 80, message="Ingredients length should be between 2 and 80 characters!")
    private String ingredients;
    @NotNull(message = "You must select a category!")
    private CategoryEnum category;

//    private User addedBy;

    public RecipesAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

//    public User getAddedBy() {
//        return addedBy;
//    }
//
//    public void setAddedBy(User addedBy) {
//        this.addedBy = addedBy;
//    }
}
