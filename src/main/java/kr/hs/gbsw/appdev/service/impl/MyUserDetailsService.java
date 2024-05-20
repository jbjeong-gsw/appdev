package kr.hs.gbsw.appdev.service.impl;

import kr.hs.gbsw.appdev.domain.MyUserDetails;
import kr.hs.gbsw.appdev.domain.User;
import kr.hs.gbsw.appdev.repository.UserRepository;
import kr.hs.gbsw.appdev.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userService.get(username);

            return new MyUserDetails(user);

        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
