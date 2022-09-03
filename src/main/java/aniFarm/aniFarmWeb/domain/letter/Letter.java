package aniFarm.aniFarmWeb.domain.letter;

import aniFarm.aniFarmWeb.domain.Anonymous;
import aniFarm.aniFarmWeb.domain.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Letter extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "letter_id")
    private Long id;

    private Long readerId;

    private Long writerId;

    private String message;

    @Enumerated(EnumType.STRING)
    private Anonymous anonymous;
}
