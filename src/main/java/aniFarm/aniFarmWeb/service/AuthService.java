package aniFarm.aniFarmWeb.service;

import aniFarm.aniFarmWeb.config.security.jwt.TokenDto;
import aniFarm.aniFarmWeb.config.security.jwt.TokenProvider;
import aniFarm.aniFarmWeb.controller.dto.member.MemberLoginIdVerifyRequest;
import aniFarm.aniFarmWeb.controller.dto.member.MemberSignInRequest;
import aniFarm.aniFarmWeb.controller.dto.member.MemberSignUpRequest;
import aniFarm.aniFarmWeb.controller.exception.ApiException;
import aniFarm.aniFarmWeb.controller.exception.ErrorCode;
import aniFarm.aniFarmWeb.domain.Member;
import aniFarm.aniFarmWeb.repository.MemberRepository;
import antlr.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;

    public void signUp(MemberSignUpRequest memberSignUpRequest) {
        Member member = Member.builder()
                .loginId(memberSignUpRequest.getLoginId())
                .password(passwordEncoder.encode(memberSignUpRequest.getPassword()))
                .nickName(memberSignUpRequest.getNickName())
                .build();
        memberRepository.save(member);
    }

    public void duplicateLoginId(MemberLoginIdVerifyRequest memberLoginIdVerifyRequest) {
        if (memberRepository.findByLoginId(memberLoginIdVerifyRequest.getLoginId()).isPresent()) {
            throw new ApiException(ErrorCode.DUPLICATE_LOGINID);
        }
    }

    public TokenDto signIn(MemberSignInRequest memberSignInRequest){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                memberSignInRequest.getLoginId(), memberSignInRequest.getPassword()
        );
        Authentication authenticate = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        TokenDto tokenDto = tokenProvider.generateTokenDto(authenticate);
        return tokenDto;
    }

    public TokenDto refresh(String refreshToken) {
        if (refreshToken == null) {
            throw new ApiException(ErrorCode.FAIL_REFRESH);
        }
        Authentication authentication = tokenProvider.getAuthentication(refreshToken);
        return tokenProvider.generateTokenDto(authentication);
    }



}
