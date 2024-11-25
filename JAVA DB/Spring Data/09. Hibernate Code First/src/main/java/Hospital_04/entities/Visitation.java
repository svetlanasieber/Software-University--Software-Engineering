package Hospital_04.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "visitations")
public class Visitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "visitation_date", nullable = false)
    private LocalDate visitationDate;

    @Column(nullable = false)
    private String comment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @ManyToOne(optional=false)
    @JoinColumn(name = "diagnose_id", referencedColumnName = "id")
    private Diagnose diagnose;

    @ManyToOne(optional=false)
    @JoinColumn(name = "medicament_id", referencedColumnName = "id")
    private Medicament medicament;

    public Visitation() {}
    public Visitation(LocalDate visitationDate, String comment, Patient patient, Diagnose diagnose, Medicament medicament) {
        this.visitationDate = visitationDate;
        this.comment = comment;
        this.patient = patient;
        this.diagnose = diagnose;
        this.medicament = medicament;
    }

    public LocalDate getVisitationDate() {
        return visitationDate;
    }

    public void setVisitationDate(LocalDate visitationDate) {
        this.visitationDate = visitationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
