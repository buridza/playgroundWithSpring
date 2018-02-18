package by.itacademy.entity.account.user;

import by.itacademy.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "friends")
public class Friends extends BaseEntity {
    @OneToMany(fetch = FetchType.EAGER)
    private Set<User> friend = new HashSet<>();
   /* @ManyToMany
    @JoinTable(
            name = "user_friends",
            joinColumns = @JoinColumn(name = "friends_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> friends;*/
}
