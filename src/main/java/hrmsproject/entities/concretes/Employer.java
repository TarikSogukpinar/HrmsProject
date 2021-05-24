package hrmsproject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "company_id")
    @NotEmpty
    @NotBlank(message = "Company ID cannot be empty !")
    private int companyId;


    @Column(name = "web_site")
    @NotBlank(message = "Web Site cannot be empty !")
    private String webSite;


    @Column(name = "phone_number")
    @NotEmpty
    @NotBlank(message = "Phone Number cannot be empty !")
    private String phoneNumber;

    @Column(name = "is_activated")
    @NotEmpty
    @NotBlank(message = "Activity status cannot be empty !")
    private boolean isActivated;

    @Column(name = "company_email")
    @NotEmpty
    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Email doesnt follow rules!")
    private boolean companyEmail;

    @Column(name = "password")
    @NotEmpty
    @NotBlank(message = "Password cannot be empty!")
    private boolean password;

    @Column(name = "confirmpassword")
    @NotEmpty
    @NotBlank(message = "Password cannot be empty!")
    private boolean confirmPassword;
}
