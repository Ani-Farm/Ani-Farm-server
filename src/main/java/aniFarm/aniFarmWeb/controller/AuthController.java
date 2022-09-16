package aniFarm.aniFarmWeb.controller;

import aniFarm.aniFarmWeb.config.security.jwt.TokenDto;
import aniFarm.aniFarmWeb.controller.dto.member.MemberLoginIdVerifyRequest;
import aniFarm.aniFarmWeb.controller.dto.member.MemberSignInRequest;
import aniFarm.aniFarmWeb.controller.dto.member.MemberSignUpRequest;
import aniFarm.aniFarmWeb.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {


    private final AuthService authService;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody MemberSignUpRequest memberSignUpRequest) {
        authService.signUp(memberSignUpRequest);
    }

    @PostMapping("/verify-id")
    public void verifyId(@RequestBody MemberLoginIdVerifyRequest memberLoginIdVerifyRequest) {
        authService.duplicateLoginId(memberLoginIdVerifyRequest);
    }

    @PostMapping("/sign-in")
    public void signIn(@RequestBody MemberSignInRequest memberSignInRequest, HttpServletResponse response) {
        TokenDto tokenDto = authService.signIn(memberSignInRequest);
        response.setHeader("Authorization","Bearer "+tokenDto.getAccessToken());
        response.setHeader("Set-Cookie", setRefreshToken(tokenDto.getRefreshToken()).toString());
    }

    @GetMapping("/refresh")
    public void refresh(@CookieValue("refreshToken") String refreshToken, HttpServletResponse response) {
        TokenDto tokenDto = authService.refresh(refreshToken);
        response.setHeader("Authorization","Bearer "+tokenDto.getAccessToken());
        response.setHeader("Set-Cookie", setRefreshToken(tokenDto.getRefreshToken()).toString());
    }


    @GetMapping("/log-out")
    public void logOut(HttpServletResponse response) {
        ResponseCookie cookie = ResponseCookie.from("RefreshToken", null)
                .maxAge(0)
                .path("/")
                .sameSite("None")  //빌드 후 배포 시엔 수정 예정
                .secure(true)
                .httpOnly(true)
                .build();

        response.setHeader("Set-Cookie", cookie.toString());
    }

    public ResponseCookie setRefreshToken(String refreshToken) {
        ResponseCookie cookie = ResponseCookie.from("RefreshToken", refreshToken)
                .httpOnly(true)
                .secure(true)
                .maxAge(60 * 60 * 24 * 7)  //7일 -> 유효기간
                .sameSite("None")
                .path("/")
                .build();
        return cookie;
    }
}
