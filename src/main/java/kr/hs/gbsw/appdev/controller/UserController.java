package kr.hs.gbsw.appdev.controller;

import kr.hs.gbsw.appdev.config.JwtProvider;
import kr.hs.gbsw.appdev.domain.LoginRequest;
import kr.hs.gbsw.appdev.domain.LoginResponse;
import kr.hs.gbsw.appdev.domain.User;
import kr.hs.gbsw.appdev.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    private final JwtProvider jwtProvider;

    @PostMapping("")
    public ResponseEntity<User> add(@RequestBody User user) {
        User saved = userService.add(user);

        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest loginRequest) {

        AbstractAuthenticationToken abstractAuthenticationToken =
            new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                    loginRequest.getPassword());

        LoginResponse response = LoginResponse.builder().build();
        try {
            Authentication authentication =
                    authenticationManager.authenticate(abstractAuthenticationToken);

            log.info("[LOGIN] authentication - {}", authentication);
            log.info("  principal - {}", authentication.getPrincipal());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // JWT을 생성한다.
            String jwt = jwtProvider.createToken(authentication);

            response.setSuccess(true);
            response.setToken(jwt);
        } catch (BadCredentialsException e) {
            response.setSuccess(false);
            response.setMessage("등록되지 않은 이메일이거나, 비밀번호가 올바르지 않습니다.");
        } catch (AccountExpiredException e) {
            response.setSuccess(false);
            response.setMessage("탈퇴한 계정입니다.");
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }

        return ResponseEntity.ok(response);
    }


}
