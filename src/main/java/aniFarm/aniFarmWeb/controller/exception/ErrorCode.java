package aniFarm.aniFarmWeb.controller.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // auth
    FAIL_REFRESH(1002, "다시 로그인을 해주세요"), //재발급시, 쿠키에 토큰 null 이면
    DUPLICATE_LOGINID(1003,"중복된 아이디입니다"),


    // member
    NOT_FOUND_MEMBER(2001, "존재하지 않는 회원입니다"),


    //post
    NOT_FOUND_POST(3001, "게시물이 존재하지 않습니다");


    //letter


    //chat

    private final int code;
    private final String message;


    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
