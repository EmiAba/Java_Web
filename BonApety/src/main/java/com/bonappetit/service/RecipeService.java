package com.bonappetit.service;

import com.bonappetit.model.dto.CocktailDTO;
import com.bonappetit.model.dto.DesertDTO;
import com.bonappetit.model.dto.MainDishDTO;
import com.bonappetit.model.dto.RecipesAddBindingModel;

import java.util.Set;

public interface RecipeService {
    void addRecipe(RecipesAddBindingModel recipesAddBindingModel);

    Set<DesertDTO> getDeserts();

    Set<MainDishDTO> getMainDish();
    Set<CocktailDTO> getCocktail();
}
