package hrmsproject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_adverts")
public class JobAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotEmpty
    @Column(name = "description")
    private String description;

    @NotNull
    @NotEmpty
    @Column(name = "salary_min")
    private int salaryMin;

    @NotNull
    @NotEmpty
    @Column(name = "salary_max")
    private int salaryMax;

    @NotNull
    @NotEmpty
    @Column(name = "open_position_count")
    private int openPositionCount;

    @NotNull
    @NotEmpty
    @Column(name = "deadline")
    private LocalDate deadline;

    @NotNull
    @NotEmpty
    @Column(name = "published_at")
    private LocalDate publishedAt;

    @NotNull
    @NotEmpty
    @Column(name = "created_at")
    private LocalDate createdAt;

    @NotNull
    @NotEmpty
    @Column(name = "is_open")
    private boolean isOpen;

    @NotNull
    @NotEmpty
    @Column(name = "is_active")
    private boolean isActive;

    @NotNull
    @NotEmpty
    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}