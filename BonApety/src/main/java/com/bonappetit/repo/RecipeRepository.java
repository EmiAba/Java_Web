package com.bonappetit.repo;


import com.bonappetit.model.dto.CocktailDTO;
import com.bonappetit.model.dto.DesertDTO;
import com.bonappetit.model.dto.MainDishDTO;
import com.bonappetit.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    @Query("select new com.bonappetit.model.dto.DesertDTO(r.name, r.ingredients)" +
            "from Recipe r\n" +
            "right join Category as c on r.category.id = c.id\n" +
            "where c.id=2")
    Set<DesertDTO> findDeserts();

    @Query("select new com.bonappetit.model.dto.MainDishDTO(r.name, r.ingredients)" +
            "from Recipe r\n" +
            "join User as u on r.addedBy.id =  u.id\n" +
            "right join Category as c on r.category.id = c.id\n" +
            "where c.id=1")
    Set<MainDishDTO> findMainDish();

    @Query("select new com.bonappetit.model.dto.CocktailDTO(r.name, r.ingredients)" +
            "from Recipe r\n" +
            "join User as u on r.addedBy.id =  u.id\n" +
            "right join Category as c on r.category.id = c.id\n" +
            "where c.id=3")
    Set<CocktailDTO> findCocktail();
}




