package kr.hs.gbsw.appdev.controller;

import kr.hs.gbsw.appdev.domain.LoginRequest;
import kr.hs.gbsw.appdev.domain.LoginResponse;
import kr.hs.gbsw.appdev.domain.User;
import kr.hs.gbsw.appdev.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    @PostMapping("")
    public ResponseEntity<User> add(@RequestBody User user) {
        User saved = userService.add(user);

        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        AbstractAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                        loginRequest.getPassword());

        LoginResponse loginResponse = null;
        try {
            Authentication authentication =
                    authenticationManager.authenticate(authenticationToken);

            loginResponse = LoginResponse.builder()
                    .success(true)
                    .jwtToken("------")
                    .build();
        } catch (BadCredentialsException e) {
            loginResponse = LoginResponse.builder()
                    .success(false)
                    .message("가입되지 않았거나, 비밀번호가 올바르지 않습니다.")
                    .build();
        }
        catch (AccountExpiredException e) {
            loginResponse = LoginResponse.builder()
                    .success(false)
                    .message("탈퇴한 계정입니다.")
                    .build();
        } catch (DisabledException e) {
            loginResponse = LoginResponse.builder()
                    .success(false)
                    .message("승인되지 않은 계정입니다.")
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            loginResponse = LoginResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }

        return ResponseEntity.ok(loginResponse);
    }
}
