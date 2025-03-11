package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {


    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, Size size);

    List<Shampoo> findBySizeOrderByIdAsc(Size parsed);

    @Query("select s from Shampoo as s " +
            "join s.ingredients as i " +
            "where i.name = :name")
    List<Shampoo> findByIngredient(@Param("name") String ingredient);


    @Query("select s from Shampoo as s " +
            "join s.ingredients as i " +
            "where i.name in :ingredients")
    List<Shampoo> findByIngredients(List<String> ingredients);

    List<Shampoo> findBySizeOrLabelId(Size size, long labelId);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    long countByPriceLessThan(BigDecimal price);

    @Query("select s from Shampoo as s " +
            "where s.ingredients.size < :count")
    List<Shampoo> findByIngredientCountsLessThan(int count);
}
