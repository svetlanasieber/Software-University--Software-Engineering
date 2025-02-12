package com.paintingscollectors.painting.repository;

import com.paintingscollectors.painting.model.FavouritePainting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FavouritePaintingRepository extends JpaRepository<FavouritePainting, UUID> {
}
