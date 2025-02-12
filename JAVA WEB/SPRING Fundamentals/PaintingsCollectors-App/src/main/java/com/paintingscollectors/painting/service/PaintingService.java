package com.paintingscollectors.painting.service;

import com.paintingscollectors.painting.model.FavouritePainting;
import com.paintingscollectors.painting.model.Painting;
import com.paintingscollectors.painting.repository.FavouritePaintingRepository;
import com.paintingscollectors.painting.repository.PaintingRepository;
import com.paintingscollectors.user.model.User;
import com.paintingscollectors.web.dto.CreatePaintingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class PaintingService {

    private final PaintingRepository paintingRepository;
    private final FavouritePaintingRepository favouritePaintingRepository;

    @Autowired
    public PaintingService(PaintingRepository paintingRepository, FavouritePaintingRepository favouritePaintingRepository) {
        this.paintingRepository = paintingRepository;
        this.favouritePaintingRepository = favouritePaintingRepository;
    }

    public void createNewPainting(CreatePaintingRequest createPaintingRequest, User user) {

        Painting painting = Painting.builder()
                .name(createPaintingRequest.getName())
                .author(createPaintingRequest.getAuthor())
                .style(createPaintingRequest.getStyle())
                .imageUrl(createPaintingRequest.getImageUrl())
                .votes(0)
                .owner(user)
                .build();

        paintingRepository.save(painting);
    }

    public void deletePaintingById(UUID id) {

        paintingRepository.deleteById(id);
    }

    public List<Painting> getAllPaintings() {

        List<Painting> allPaintings = paintingRepository.findAll();

        allPaintings.sort(Comparator.comparing(Painting::getVotes).reversed().thenComparing(Painting::getName));

        return allPaintings;
    }

    public void createFavouriteByPaintingId(UUID paintingId, User user) {

        Painting painting = getById(paintingId);

        boolean isAlreadyFavourite = user.getFavouritePaintings()
                .stream()
                .anyMatch(fp -> fp.getName().equals(painting.getName()) && fp.getAuthor().equals(painting.getAuthor()));
        if (isAlreadyFavourite){
            return;
        }

        FavouritePainting favouritePainting = FavouritePainting.builder()
                .name(painting.getName())
                .author(painting.getAuthor())
                .owner(user)
                .imageUrl(painting.getImageUrl())
                .createdOn(LocalDateTime.now())
                .build();

        favouritePaintingRepository.save(favouritePainting);
    }

    private Painting getById(UUID paintingId) {

        return paintingRepository.findById(paintingId).orElseThrow(() -> new RuntimeException("Painting with id %s does not exist".formatted(paintingId)));
    }

    public void incrementVotesByOne(UUID paintingId) {

        Painting painting = getById(paintingId);

        painting.setVotes(painting.getVotes() + 1);
        paintingRepository.save(painting);
    }

    public void deleteFavouriteById(UUID id) {

        favouritePaintingRepository.deleteById(id);
    }
}
