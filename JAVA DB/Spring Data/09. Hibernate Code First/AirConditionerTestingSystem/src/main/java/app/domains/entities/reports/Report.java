package app.domains.entities.reports;

import app.domains.entities.airConditioners.AbstractAirConditioner;
import app.domains.enums.Mark;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Report {

    private Long id;

    private Mark mark;

    private AbstractAirConditioner abstractAirConditioner;

    public Report() {
        super();
    }

    public Report(Mark mark, AbstractAirConditioner abstractAirConditioner) {
        this.mark = mark;
        this.abstractAirConditioner = abstractAirConditioner;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public Mark getMark() {
        return this.mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @OneToOne
    @JoinColumn(name = "conditioner_id", referencedColumnName = "id")
    public AbstractAirConditioner getAbstractAirConditioner() {
        return this.abstractAirConditioner;
    }

    public void setAbstractAirConditioner(AbstractAirConditioner abstractAirConditioner) {
        this.abstractAirConditioner = abstractAirConditioner;
    }
}
