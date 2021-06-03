package hrmsproject.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;

    @NotNull
    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotNull
    @NotEmpty
    @Column(name = "department")
    private String department;

    @NotNull
    @NotEmpty
    @Column(name = "start_date")
    private LocalDate startDate;

    @NotNull
    @NotEmpty
    @Column(name = "finish_date")
    private LocalDate finishDate;

    @JsonIgnore
    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();
}
