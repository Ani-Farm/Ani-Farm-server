package aniFarm.aniFarmWeb.domain.chat;

import aniFarm.aniFarmWeb.domain.BaseEntity;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class ChatRoom extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "chatRoom_id")
    private Long id;

    private String title;

    @OneToMany(mappedBy = "chatRoom")
    List<Chat> chats = new ArrayList<>();

}
