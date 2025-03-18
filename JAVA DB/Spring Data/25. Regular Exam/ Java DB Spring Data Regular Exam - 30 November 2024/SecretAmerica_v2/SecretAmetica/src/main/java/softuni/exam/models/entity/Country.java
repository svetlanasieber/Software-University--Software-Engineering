package softuni.exam.models.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {

    private double area;
    private String name;


    private Set<Attraction> attractions = new HashSet<>();

    private Set<Visitor> visitors = new HashSet<>();

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    public Set<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(Set<Attraction> attractions) {
        this.attractions = attractions;
    }
//
//
//    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
//    public Set<Visitor> getVisitors() {
//        return visitors;
//    }
//
//    public void setVisitors(Set<Visitor> visitors) {
//        this.visitors = visitors;
//    }
}
