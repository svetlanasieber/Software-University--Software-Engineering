package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.repositories.CustomRepo;
import com.example.advquerying.repositories.IngredientRepository;
import com.example.advquerying.repositories.LabelRepository;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class Runner implements CommandLineRunner {
    private final ShampooRepository shampooRepository;
    private final LabelRepository labelRepository;
    private final IngredientRepository ingredientRepository;
    private final CustomRepo customRepo;

    public Runner(
            ShampooRepository shampooRepository,
            LabelRepository labelRepository,
            IngredientRepository ingredientRepository,
            CustomRepo customRepo) {
        this.shampooRepository = shampooRepository;
        this.labelRepository = labelRepository;
        this.ingredientRepository = ingredientRepository;
        this.customRepo = customRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Working");

//        Optional<Label> label = labelRepository.findById(4L);

//        List<Ingredient> ingredients = ingredientRepository
//                .findByNameInOrderByPriceAsc(List.of("Lavender", "Herbs", "Apple"));
//
//        System.out.println(ingredients);

//        List<Shampoo> shampoos = shampooRepository
//            .findByIngredientsCountLessThan(2);
//
//        System.out.println(shampoos);
//
//        int count = shampooRepository.countByPriceLessThan(BigDecimal.valueOf(8.50));
//
//        System.out.println(count);

//        Shampoo firstShampoo = customRepo.getFirstShampoo();
//        System.out.println(firstShampoo);

//        ingredientRepository.deleteByName("Lavender");

//        Optional<Shampoo> shampoo = shampooRepository.findById(1L);
//        // @Transactional if this is a LAZY collection
//        Set<Ingredient> ingredients = shampoo.get().getIngredients();
//
//        System.out.println(ingredients.size());

//        ingredientRepository.updateIngredientsPricesForNames(List.of("Lavender"));

        List<Shampoo> byBrandNative = shampooRepository.findByBrandNative("Swiss Green Apple & Nettle");

        System.out.println();
    }
}
