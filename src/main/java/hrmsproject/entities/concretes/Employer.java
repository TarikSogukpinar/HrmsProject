package hrmsproject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employers")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdverts"})
public class Employer extends User {
    @NotNull
    @NotEmpty
    @Column(name = "company_name")
    private String companyName;

    @NotNull
    @NotEmpty
    @Column(name = "website")
    private String website;

    @NotNull
    @NotEmpty
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_verified", columnDefinition = "boolean default false")
    private boolean isVerified = false;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvert> jobAdverts;

}