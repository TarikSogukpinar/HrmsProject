package hrmsproject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @NotNull
    @NotEmpty
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city")
    private List<JobAdvert> jobAdverts;
}
