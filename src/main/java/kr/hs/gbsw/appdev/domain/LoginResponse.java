package kr.hs.gbsw.appdev.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LoginResponse {
    private boolean success;

    private String message;

    private String jwtToken;
}
