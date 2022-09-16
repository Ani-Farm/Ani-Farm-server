package aniFarm.aniFarmWeb.controller.dto.member;

import lombok.Data;

@Data
public class MemberSignInRequest {

    private String loginId;

    private String password;
}
