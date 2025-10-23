package main.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wizards")
public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String avatarUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WizardAlignment alignment;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private House house;

    @OneToMany(mappedBy = "wizard", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Builder.Default
    private List<Spell> spells = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

    public int getTotalPower() {
        return spells.stream()
                .mapToInt(Spell::getPower)
                .sum();
    }
}
