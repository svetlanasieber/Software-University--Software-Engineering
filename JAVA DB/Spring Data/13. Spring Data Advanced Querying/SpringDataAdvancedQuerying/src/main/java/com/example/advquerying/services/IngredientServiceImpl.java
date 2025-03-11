package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> selectByName(String name) {
        return this.ingredientRepository.findByNameStartsWith(name);
    }

    @Override
    public List<Ingredient> selectByNames(List<String> names) {
        return this.ingredientRepository.findByNameInOrderByPrice(names);
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
       this.ingredientRepository.deleteByName(name);
    }


    @Override
    @Transactional
    public void updatePrice(){
        this.ingredientRepository.updateAllPrice();
    }

    @Override
    @Transactional
    public void updatePriceByName(List<String> names) {
        this.ingredientRepository.updateAllPriceByName(names);
    }


}
