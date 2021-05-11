package hrmsproject.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "job_positions")
public class Position {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "job_title")
    private String name;
}
