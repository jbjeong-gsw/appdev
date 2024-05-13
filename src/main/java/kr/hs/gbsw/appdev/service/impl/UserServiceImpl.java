package kr.hs.gbsw.appdev.service.impl;

import jakarta.persistence.EntityManager;
import kr.hs.gbsw.appdev.domain.User;
import kr.hs.gbsw.appdev.entity.UserEntity;
import kr.hs.gbsw.appdev.repository.UserRepository;
import kr.hs.gbsw.appdev.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final EntityManager entityManager;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User add(User user) {
        UserEntity entity = User.toEntity(user);
        entity.setRegisterTime(new Date());

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        entity.setPassword(encodedPassword);

        userRepository.save(entity);
        entityManager.clear();

        return get(entity.getUserIdx());
    }

    @Override
    public User get(int idx) {
        UserEntity entity = userRepository.findById(idx).orElseThrow();

        return User.toDomain(entity);
    }

    @Override
    public User update(User user) {
        UserEntity entity = User.toEntity(user);

        userRepository.save(entity);

        return get(entity.getUserIdx());
    }

    @Override
    public void remove(int userIdx) {
        //userRepository.deleteById(userIdx);
        userRepository.withdraw(userIdx, new Date());
    }
}
