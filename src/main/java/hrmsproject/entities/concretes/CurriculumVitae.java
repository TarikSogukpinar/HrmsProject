package hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curriculum_vitaes")
public class CurriculumVitae {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @NotNull
    @NotEmpty
    @Column(name = "github_adress")
    private String githubAddress;

    @NotNull
    @NotEmpty
    @Column(name = "linkedin_adress")
    private String linkedinAddress;

    @NotNull
    @NotEmpty
    @Column(name = "technologies")
    private String technologies;

    @NotNull
    @NotEmpty
    @Column(name = "description")
    private String description;

    @NotNull
    @NotEmpty
    @Column(name = "languages")
    private String languages;

    @NotNull
    @Column(name = "created_Date")
    private LocalDate createdDate = LocalDate.now();

    @OneToMany(mappedBy = "curriculumVitae")
    @JsonIgnore
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "curriculumVitae")
    @JsonIgnore
    private List<School> schools;

    @OneToMany(mappedBy = "curriculumVitae")
    @JsonIgnore
    private List<ForeignLanguage> foreignLanguages;

}
