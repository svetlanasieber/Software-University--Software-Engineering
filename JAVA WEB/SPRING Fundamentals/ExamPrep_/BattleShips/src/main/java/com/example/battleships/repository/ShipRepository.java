package com.example.battleships.repository;

import com.example.battleships.model.entity.Ship;
import com.example.battleships.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    List<Ship> findByUser_Id(Long user_id);

    @Query("SELECT s FROM Ship s WHERE s.user.id NOT IN :u_id")
    List<Ship> findAllOtherShips(@Param(value = "u_id") Long user_id);

    Optional<Ship> getByName(String name);
}
