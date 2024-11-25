package com.example.advquerying.repositories;

import com.example.advquerying.entities.Label;
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

    List<Shampoo> findBySizeOrderByIdDesc(Size size);

    List<Shampoo> findBySizeOrLabelId(Size size, long labelId);

    List<Shampoo> findBySizeOrLabel(Size size, Label label);

    List<Shampoo> findByLabelTitleContaining(String title);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countByPriceLessThan(BigDecimal price);

    List<Shampoo> findByIngredientsNameIn(List<String> names);

    @Query("SELECT s.size, AVG(s.price)" +
            " FROM Shampoo AS s" +
            " GROUP BY s.size")
    List<Object> findPriceBySize();

//    @Query("SELECT s FROM Shampoo AS s" +
//            " JOIN s.ingredients AS i" +
//            " WHERE i.name IN :names")
    @Query("""
        SELECT s FROM Shampoo AS s
        JOIN s.ingredients AS i
        WHERE i.name IN :names
        """)
    List<Shampoo> findByIngredientsNameInQuery(@Param("names") List<String> ingNames);

    @Query("SELECT s FROM Shampoo AS s" +
            " WHERE SIZE(s.ingredients) < :count")
//    @Query(value = "SELECT * FROM shampoos s JOIN shampoos_ingredients...", nativeQuery = true)
    List<Shampoo> findByIngredientsCountLessThan(int count);

    @Query(value = "SELECT * FROM shampoos WHERE brand = :brand", nativeQuery = true)
    List<Shampoo> findByBrandNative(String brand);

}
