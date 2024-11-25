package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CustomRepo {
    @PersistenceContext
    private EntityManager em;

    public Shampoo getFirstShampoo() {
        return em.find(Shampoo.class, 1L);
    }
}
