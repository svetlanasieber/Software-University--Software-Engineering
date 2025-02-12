package com.paintingscollectors.painting.repository;

import com.paintingscollectors.painting.model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaintingRepository extends JpaRepository<Painting, UUID> {


}
