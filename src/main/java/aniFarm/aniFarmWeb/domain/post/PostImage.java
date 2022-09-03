package aniFarm.aniFarmWeb.domain.post;

import aniFarm.aniFarmWeb.domain.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class PostImage extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "post_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private String post_image_url;
}
