package hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="foreign_languages")
public class ForeignLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;

    @NotNull
    @NotEmpty
    @Column(name = "language")
    private String language;

    @Min(1)
    @Max(5)
    @NotNull
    @NotEmpty
    @Column(name = "level")
    private int level;

    @JsonIgnore
    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

}
