package by.itacademy.entity.account.user;

import by.itacademy.entity.account.Account;
import by.itacademy.entity.account.Address;
import by.itacademy.entity.game.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class User extends Account {
    @Column(name = "date", nullable = false)
    private LocalDate dateOfBirthday;

    @Column(name = "role", unique = false, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "language", nullable = false)
    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id")
    private Friends friends;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @Column(name = "games")
    private Set<Game> games = new HashSet<>();

    public User(Address address, String name, String login, String password, String email, LocalDate dateOfBirthday, Language language) {
        super(address, name, login, password, email);
        this.dateOfBirthday = dateOfBirthday;
        this.language = language;
    }

}
