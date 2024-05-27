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
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest loginRequest) {

        AbstractAuthenticationToken abstractAuthenticationToken =
            new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                    loginRequest.getPassword());

        try {
            Authentication authentication =
                    authenticationManager.authenticate(abstractAuthenticationToken);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }



        return null;
    }


}
