package by.itacademy.entity.account.user;

import by.itacademy.entity.BaseEntity;
import by.itacademy.entity.game.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "comments")
public class Comment extends BaseEntity {
    @Version
    private Long version;
    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "message")
    private String message;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "game")
    private Game game;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}
