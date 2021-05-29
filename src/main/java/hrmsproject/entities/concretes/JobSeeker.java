package hrmsproject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "jobseekers")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {


    @NotNull
    @NotEmpty
    @Column(name= "first_name")
    private String firstName;

    @NotNull
    @NotEmpty
    @Column(name= "last_name")
    private String lastName;

    @NotNull
    @NotEmpty
    @Column(name= "national_id")
    private String nationalId;

    @NotNull
    @NotEmpty
    @Column(name= "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "is_verified", columnDefinition = "boolean default false")
    private boolean isVerified = false;

}