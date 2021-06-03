package hrmsproject.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_positions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class JobPosition {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @NotNull
    @NotEmpty
    @Column(name="job_title")
    private String jobTitle;

    @NotNull
    @NotEmpty
    @Column(name= "created_at")
    private LocalDate createdDate = LocalDate.now();

    @NotNull
    @NotEmpty
    @Column(name= "is_active")
    private boolean isActive = true;

    @NotNull
    @NotEmpty
    @Column(name= "is_deleted")
    private boolean isDeleted = false;

    @OneToMany(mappedBy = "jobPosition")
    private List<JobAdvert> jobAdverts;

}
