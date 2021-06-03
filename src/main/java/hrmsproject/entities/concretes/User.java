package hrmsproject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;

    @NotNull
    @NotEmpty
    @Email
    @Column(name= "email")
    private String email;

    @NotNull
    @NotEmpty
    @Column(name= "password")
    private String password;

    @Column(name= "created_at")
    private LocalDate createdAt = LocalDate.now();

    @Column(name= "is_active")
    private boolean isActive = true;

    @Column(name= "is_deleted")
    private boolean isDeleted = false;

}