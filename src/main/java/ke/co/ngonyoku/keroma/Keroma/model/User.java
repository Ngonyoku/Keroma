package ke.co.ngonyoku.keroma.Keroma.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    @Column(nullable = false)
    private String email;

    private String password;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Order> orders;

    public User(
            String firstName,
            String lastName,
            String email
    ) {

    }
}
