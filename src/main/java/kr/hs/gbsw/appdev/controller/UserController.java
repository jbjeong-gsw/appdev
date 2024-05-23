package kr.hs.gbsw.appdev.controller;

import kr.hs.gbsw.appdev.domain.LoginRequest;
import kr.hs.gbsw.appdev.domain.User;
import kr.hs.gbsw.appdev.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

        try {
            Authentication authentication =
                    authenticationManager.authenticate(authenticationToken);

            return ResponseEntity.ok(authentication);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return ResponseEntity.ok("Fail");


    }
}
