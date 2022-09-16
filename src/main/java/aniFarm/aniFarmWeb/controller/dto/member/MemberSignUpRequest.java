package aniFarm.aniFarmWeb.controller.dto.member;

import lombok.Data;

@Data
public class MemberSignUpRequest {
    private String loginId;

    private String password;

    private String nickName;

}
