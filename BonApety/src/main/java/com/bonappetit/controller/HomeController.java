package com.bonappetit.controller;

import com.bonappetit.model.dto.CocktailDTO;
import com.bonappetit.model.dto.DesertDTO;
import com.bonappetit.model.dto.MainDishDTO;
import com.bonappetit.service.RecipeService;
import com.bonappetit.service.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class HomeController {

private LoggedUser loggedUser;
    private final RecipeService recipeService;
    private long size = 0;

    public HomeController(LoggedUser loggedUser, RecipeService recipeService) {
        this.loggedUser = loggedUser;
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public ModelAndView index(){
        if(loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public String homePage(Model model){

        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }
        size = 0;
        Set<DesertDTO> desertDTO = this.recipeService.getDeserts();
        model.addAttribute("desertDTO", desertDTO);
        size += desertDTO.size();
        Set<MainDishDTO> mainDishDTO = this.recipeService.getMainDish();
        model.addAttribute("mainDishDTO", mainDishDTO);
        size += mainDishDTO.size();

        Set<CocktailDTO> cocktailDTO = this.recipeService.getCocktail();
        model.addAttribute("cocktailDTO", cocktailDTO);
        size += cocktailDTO.size();

        return "home";
    }


}
