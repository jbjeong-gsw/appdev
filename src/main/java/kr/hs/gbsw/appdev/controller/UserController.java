package kr.hs.gbsw.appdev.controller;

import kr.hs.gbsw.appdev.domain.User;
import kr.hs.gbsw.appdev.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<User> add(@RequestBody User user) {
        User saved = userService.add(user);

        return ResponseEntity.ok(saved);
    }
}
