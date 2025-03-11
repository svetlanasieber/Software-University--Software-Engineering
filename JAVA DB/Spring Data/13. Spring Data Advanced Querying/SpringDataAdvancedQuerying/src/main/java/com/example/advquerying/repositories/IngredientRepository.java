package com.example.advquerying.repositories;


import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByNameStartsWith(String name);

    List<Ingredient> findByNameInOrderByPrice(List<String> names);

    void deleteByName(String name);

    @Query("update Ingredient as i " +
            "set i.price = i.price * 1.10")
    @Modifying
    void updateAllPrice();

    @Query("update Ingredient as i " +
            "set i.price = i.price * 2 " +
            "where i.name in :names")
    @Modifying
    void updateAllPriceByName(List<String> names);
}
