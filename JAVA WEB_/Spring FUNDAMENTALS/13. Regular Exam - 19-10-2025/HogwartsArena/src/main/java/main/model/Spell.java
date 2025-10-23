package main.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "spells")
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "wizard_id", nullable = false)
    private Wizard wizard;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SpellCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SpellAlignment alignment;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private int power;

    @Column(nullable = false)
    private LocalDateTime createdOn;
}
