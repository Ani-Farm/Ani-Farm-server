package aniFarm.aniFarmWeb.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Anonymous {

    OPEN("open"),
    ANONYMOUS("anonymous");

    private final String value;

    private Anonymous(String value) {
        this.value = value;
    }


    // 직렬화 (request -> object)
    @JsonCreator
    public static Anonymous from(String value) {
        for (Anonymous anonymous : Anonymous.values()) {
            if (anonymous.getValue().equals(value)) {
                return anonymous;
            }
        }
        return null;
    }

    // 역직렬화 (object -> request)
    @JsonValue
    public String getValue() {
        return value;
    }
}
