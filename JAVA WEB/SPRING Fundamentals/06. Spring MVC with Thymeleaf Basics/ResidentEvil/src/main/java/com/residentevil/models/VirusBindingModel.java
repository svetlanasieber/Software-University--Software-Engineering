package com.residentevil.models;

import com.residentevil.annotations.IsInTheFuture;
import com.residentevil.enums.Magnitude;
import com.residentevil.enums.Mutation;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class VirusBindingModel {

    private String name;

    private String description;

    private String creator;

    private String sideEffects;

    private Boolean isDeadly;

    private Boolean isCurable;

    private Mutation mutation;

    private Double turnoverRate;

    private Integer hoursToTurn;

    private Magnitude magnitude;

    private Date releasedOn;

    private String[] capitals;

    public VirusBindingModel() {
        super();
    }

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 5, max = 30, message = "Invalid Name size")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Cannot be blank")
    @Size(min = 5, max = 100, message = "Invalid Desc size")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Pattern(regexp = "^.*[Cc]orp.*$", message = "Doesn't contain Corp")
    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Size(max = 50)
    public String getSideEffects() {
        return this.sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public Boolean getDeadly() {
        return this.isDeadly;
    }

    public void setDeadly(Boolean deadly) {
        isDeadly = deadly;
    }

    public Boolean getCurable() {
        return this.isCurable;
    }

    public void setCurable(Boolean curable) {
        isCurable = curable;
    }

    @NotNull(message = "Should have a mutation")
    public Mutation getMutation() {
        return this.mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    @Range(min = 0, max = 100)
    public Double getTurnoverRate() {
        return this.turnoverRate;
    }

    public void setTurnoverRate(Double turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    @Range(min = 0, max = 12)
    public Integer getHoursToTurn() {
        return this.hoursToTurn;
    }

    public void setHoursToTurn(Integer hoursToTurn) {
        this.hoursToTurn = hoursToTurn;
    }

    @NotNull(message = "Cannot be null")
    public Magnitude getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    @IsInTheFuture(message = "Is in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getReleasedOn() {
        return this.releasedOn;
    }

    public void setReleasedOn(Date releasedOn) {
        this.releasedOn = releasedOn;
    }

    @NotEmpty(message = "Should pick capitals")
    public String[] getCapitals() {
        return this.capitals;
    }

    public void setCapitals(String[] capitals) {
        this.capitals = capitals;
    }
}
