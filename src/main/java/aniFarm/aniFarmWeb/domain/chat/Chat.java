package aniFarm.aniFarmWeb.domain.chat;

import aniFarm.aniFarmWeb.domain.BaseEntity;
import aniFarm.aniFarmWeb.domain.Member;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Chat extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "chat_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatRoom_id")
    private ChatRoom chatRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String message;


}
