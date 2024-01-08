package com.bonappetit.model.entity;

import com.bonappetit.model.CategoryEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private CategoryEnum name;

    @Column(nullable = false)
    private String description;


    @OneToMany(mappedBy = "category")
    private Set<Recipe> recipes;

    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
        setDescription(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    private void setDescription(CategoryEnum name) {
        String description = "";

        switch (name) {
            case MAIN_DISH -> description = "Heart of the meal, substantial and satisfying; main dish delights taste buds.";
            case DESSERT -> description = "Sweet finale, indulgent and delightful; dessert crowns the dining experience with joy.";
            case COCKTAIL -> description = "Sip of sophistication, cocktails blend flavors, creating a spirited symphony in every glass.";
        }

        this.description = description;
    }



}
