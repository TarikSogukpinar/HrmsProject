package hrmsproject.core.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @NotEmpty
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email doesnt follow rules")
    private String email;


    @Column(name = "password")
    @NotBlank(message = "Password cannot be empty!")
    private String password;


    @Column(name = "confirmpassword")
    @NotEmpty
    @NotBlank(message = "Password cannot be empty !")
    private String confirmPassword;

    @Column(name = "firstname")
    @NotEmpty
    @NotBlank(message = "First Name cannot be empty!")
    private String firstName;

    @Column(name = "lastname")
    @NotEmpty
    @NotBlank(message = "Last Name cannot be empty!")
    private String lastName;

    @Column(name = "national_id")
    @NotEmpty
    @NotBlank(message = "National ID cannot be empty !")
    private String nationalId;


}
