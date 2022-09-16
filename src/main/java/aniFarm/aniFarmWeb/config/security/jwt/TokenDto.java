package aniFarm.aniFarmWeb.config.security.jwt;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenDto {

    private String accessToken; // 접근 토큰

    private String refreshToken;

}
