package com.residentevil.entities;

import com.residentevil.enums.Magnitude;
import com.residentevil.enums.Mutation;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "viruses")
public class Virus {

    private Long id;

    private String name;

    private String description;

    private String creator;

    private String sideEffects;

    private Boolean isDeadly;

    private Boolean isCurable;

    private Mutation mutation;

    private Double turnoverRate;

    private int hoursToTurn;

    private Magnitude magnitude;

    private Date releasedOn;

    private Set<Capital> capitals;

    public Virus() {
        super();

        this.capitals = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT", name = "description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "creator")
    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Column(name = "side_effects")
    public String getSideEffects() {
        return this.sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    @Column(name = "deadly")
    public Boolean getDeadly() {
        return this.isDeadly;
    }

    public void setDeadly(Boolean deadly) {
        isDeadly = deadly;
    }

    @Column(name = "curable")
    public Boolean getCurable() {
        return this.isCurable;
    }

    public void setCurable(Boolean curable) {
        isCurable = curable;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "mutation")
    public Mutation getMutation() {
        return this.mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    @Column(name = "turnover_rate")
    public Double getTurnoverRate() {
        return this.turnoverRate;
    }

    public void setTurnoverRate(Double turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    @Column(name = "hours_to_turn")
    public int getHoursToTurn() {
        return this.hoursToTurn;
    }

    public void setHoursToTurn(int hoursToTurn) {
        this.hoursToTurn = hoursToTurn;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "magnitude")
    public Magnitude getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

//    @Column(name = "released_on")
    public Date getReleasedOn() {
        return this.releasedOn;
    }

    public void setReleasedOn(Date releasedOn) {
        this.releasedOn = releasedOn;
    }

    @ManyToMany
    @JoinTable(name = "viruses_capitals",
        joinColumns = @JoinColumn(name = "virus_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "capital_id", referencedColumnName = "id"))
    public Set<Capital> getCapitals() {
        return this.capitals;
    }

    public void setCapitals(Set<Capital> capitals) {
        this.capitals = capitals;
    }
}
