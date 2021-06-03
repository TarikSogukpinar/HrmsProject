package hrmsproject.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_experience")
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;


    @NotNull
    @NotEmpty
    @Column(name = "workplace_name")
    private String workplaceName;

    @NotNull
    @NotEmpty
    @Column(name = "position_name")
    private String positionName;

    @NotNull
    @NotEmpty
    @Column(name = "start_date")
    private LocalDate startDate;

    @NotNull
    @NotEmpty
    @Column(name = "end_date")
    private LocalDate endDate;

    @JsonIgnore
    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

}
