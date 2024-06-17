package kr.hs.gbsw.appdev.service.impl;

import kr.hs.gbsw.appdev.domain.MyUserDetails;
import kr.hs.gbsw.appdev.domain.User;
import kr.hs.gbsw.appdev.entity.UserEntity;
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

    //private final UserService userService;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserEntity entity = userRepository.findByEmail(username).orElseThrow();
            User user = User.toDomain(entity);

            return new MyUserDetails(user);

        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
