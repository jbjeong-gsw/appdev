package kr.hs.gbsw.appdev.domain;

import kr.hs.gbsw.appdev.entity.UserEntity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private int userIdx;

    private String email;

    private String name;

    private String password;

    private int grade;

    private Date registerTime;

    private Date lastLoginTime;

    private String withdrawedYn;

    private Date withdrawTime;

    public static UserEntity toEntity(User domain) {
        return UserEntity.builder()
                .userIdx(domain.getUserIdx())
                .email(domain.getEmail())
                .name(domain.getName())
                .password(domain.getPassword())
                .grade(domain.getGrade())
                .registerTime(domain.getRegisterTime())
                .lastLoginTime(domain.getLastLoginTime())
                .withdrawedYn(domain.getWithdrawedYn())
                .withdrawTime(domain.getWithdrawTime())
                .build();
    }

    public static User toDomain(UserEntity entity) {
        return User.builder()
                .userIdx(entity.getUserIdx())
                .email(entity.getEmail())
                .name(entity.getName())
                .password(entity.getPassword())
                .grade(entity.getGrade())
                .registerTime(entity.getRegisterTime())
                .lastLoginTime(entity.getLastLoginTime())
                .withdrawedYn(entity.getWithdrawedYn())
                .withdrawTime(entity.getWithdrawTime())
                .build();

    }

}
