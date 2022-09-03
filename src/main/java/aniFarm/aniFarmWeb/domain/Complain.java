package aniFarm.aniFarmWeb.domain;

import aniFarm.aniFarmWeb.domain.post.Post;
import aniFarm.aniFarmWeb.domain.post.Reply;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Complain extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "complain_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_id")
    private Reply reply;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String content;

}
