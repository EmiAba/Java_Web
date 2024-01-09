package com.bonappetit.model.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Table(name="users")
public class User extends  BaseEntity {



    @Length(min = 2, max = 40)
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "addedBy", fetch = FetchType.EAGER)
    private Set<Recipe> addedRecipes;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Recipe> favouriteRecipes;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Recipe> getAddedRecipes() {
        return addedRecipes;
    }

    public void setAddedRecipes(Set<Recipe> addedRecipes) {
        this.addedRecipes = addedRecipes;
    }

    public Set<Recipe> getFavouriteRecipes() {
        return favouriteRecipes;
    }

    public void setFavouriteRecipes(Set<Recipe> favouriteRecipes) {
        this.favouriteRecipes = favouriteRecipes;
    }


}
