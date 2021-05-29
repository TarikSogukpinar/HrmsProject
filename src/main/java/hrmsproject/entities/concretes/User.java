package hrmsproject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
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
    @GeneratedValue
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

    @Column(name= "created_at", columnDefinition = "Date defult CURRENT_DATE")
    private LocalDate createdAt = LocalDate.now();

    @Column(name= "is_active", columnDefinition = "boolean default true")
    private boolean isActive = true;

    @Column(name= "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted = false;

}