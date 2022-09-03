package aniFarm.aniFarmWeb.domain.post;

import aniFarm.aniFarmWeb.domain.Anonymous;
import aniFarm.aniFarmWeb.domain.BaseEntity;
import aniFarm.aniFarmWeb.domain.Member;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    private String content;

    private int likes;

    private int hates;

    private int hit;

    @Enumerated(EnumType.STRING)
    private Anonymous anonymous;

    // lifecycle 에 종속적
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PostImage> postImages = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    List<Reply> replies = new ArrayList<>();
}
