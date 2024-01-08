package com.bonappetit.service.impl;

import com.bonappetit.model.dto.CocktailDTO;
import com.bonappetit.model.dto.DesertDTO;
import com.bonappetit.model.dto.MainDishDTO;
import com.bonappetit.model.dto.RecipesAddBindingModel;
import com.bonappetit.model.entity.Category;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.repo.CategoryRepository;
import com.bonappetit.repo.RecipeRepository;
import com.bonappetit.repo.UserRepository;
import com.bonappetit.service.RecipeService;
import com.bonappetit.service.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private LoggedUser loggedUser;


    public RecipeServiceImpl(RecipeRepository recipeRepository,
                             CategoryRepository categoryRepository,
                             UserRepository userRepository, LoggedUser loggedUser, LoggedUser loggedUser1) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser1;
    }

    @Override
    public void addRecipe(RecipesAddBindingModel recipesAddBindingModel) {

        Category category = categoryRepository.findByName(recipesAddBindingModel.getCategory());

        if (category != null) {
            Recipe recipe = new Recipe();
            recipe.setName(recipesAddBindingModel.getName());
            recipe.setIngredients(recipesAddBindingModel.getIngredients());
            recipe.setCategory(category);

                Long userId = loggedUser.getId();
            this.userRepository.findByUsernameOrId(loggedUser.getUsername(), userId).map(user -> {
                    recipe.setAddedBy(user);
                    return user;
                }).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));;



                recipeRepository.save(recipe);
            }

        }


    public Set<DesertDTO> getDeserts() {
        return this.recipeRepository.findDeserts();
    }
    public Set<MainDishDTO> getMainDish() {
        return this.recipeRepository.findMainDish();
    }

    public Set<CocktailDTO> getCocktail() {
        return this.recipeRepository.findCocktail();
    }

//    public void addFavourite(Long id) {
//        this .recipeRepository.add(id);
//    }

    }

