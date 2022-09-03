package aniFarm.aniFarmWeb.domain.post;

import aniFarm.aniFarmWeb.domain.Anonymous;
import aniFarm.aniFarmWeb.domain.BaseEntity;
import aniFarm.aniFarmWeb.domain.Member;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "reply_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String content;

    @Enumerated(EnumType.STRING)
    private Anonymous anonymous;
}
