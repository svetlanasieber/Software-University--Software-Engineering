package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByNameStartingWith(String start);

    List<Ingredient> findByNameInOrderByPriceAsc(List<String> wanted);

    @Transactional
    void deleteByName(String name);

    @Query("UPDATE Ingredient i SET i.price = i.price * 1.1")
    @Modifying
    @Transactional
    void updateIngredientsPriceBy10Percent();

    @Query("UPDATE Ingredient i SET i.price = i.price * 1.1 WHERE i.name IN :names")
    @Modifying
    @Transactional
    void updateIngredientsPricesForNames(List<String> names);
}
