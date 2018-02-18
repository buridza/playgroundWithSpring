package by.itacademy.entity.game;

import by.itacademy.entity.BaseEntity;
import by.itacademy.entity.account.provider.Provider;
import by.itacademy.entity.account.user.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@AllArgsConstructor
@Table(name = "game")
public class Game extends BaseEntity {
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "rules", unique = true, nullable = false)
    private String rules;
    @Column(name = "cost", nullable = false)
    private int cost;
    @Column(name = "age_restrictions")
    private int ageRestrictions;
    @Column(name = "numberOfPlayers", nullable = false)
    private int numberOfPlayers;
    @Column(name = "language")
    private Language language;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Provider provider;

}
