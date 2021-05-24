package hrmsproject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "first_name")
    @NotEmpty
    @NotBlank(message = "Employee first name cannot be empty!")
    private String firstName;


    @Column(name = "last_name")
    @NotBlank(message = "Employee last name cannot be empty!")
    private String lastName;

    @Column(name = "department_id")
    @NotBlank(message = "Departmant ID cannot be empty!")
    private int departmentId;
}
