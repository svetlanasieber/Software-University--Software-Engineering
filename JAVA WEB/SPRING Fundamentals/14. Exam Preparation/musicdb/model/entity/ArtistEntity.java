package com.example.musicdb.model.entity;

import com.example.musicdb.model.enums.ArtistEnum;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class ArtistEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ArtistEnum name;

    @Column(name = "career_information", columnDefinition = "TEXT")
    private String careerInformation;

    public ArtistEntity() {
    }

    public ArtistEnum getName() {
        return name;
    }

    public void setName(ArtistEnum name) {
        this.name = name;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
