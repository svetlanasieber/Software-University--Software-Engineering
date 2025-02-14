package com.residentevil.repositories;

import com.residentevil.entities.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CapitalRepository extends JpaRepository<Capital, Long> {

    @Query(value = "SELECT c.name FROM Capital AS c")
    List<String> getCapitalNames();

    Set<Capital> getAllByNameIn(String[] names);
}
