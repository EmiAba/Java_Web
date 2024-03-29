package com.bonappetit.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Entity
@Table(name = "recipes")
public class Recipe extends BaseEntity {
    @Column(nullable = false)
    @Length(min = 2, max = 40)
    private String name;
    @Length(min = 2, max = 150)
    private String ingredients;
    @ManyToOne
    @NotNull
    private Category category;
    @ManyToOne
    private User addedBy;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAddedBy(Optional<User> user) {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }
}
