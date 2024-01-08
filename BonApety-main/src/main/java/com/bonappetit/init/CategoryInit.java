package com.bonappetit.init;

import com.bonappetit.model.CategoryEnum;
import com.bonappetit.model.entity.Category;
import com.bonappetit.repo.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CategoryInit implements CommandLineRunner {
private final CategoryRepository categoryRepository;

    public CategoryInit(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Category> priorities=new ArrayList<>();
        boolean hasCategory=categoryRepository.count()>0;

        if(!hasCategory){
            Arrays.stream(CategoryEnum.values())
                    .forEach(categoryEnum -> {
                       Category category=new Category();

                        category.setName(categoryEnum);
                        priorities.add(category);
                    });
            categoryRepository.saveAll(priorities);
        }

    }

    }

