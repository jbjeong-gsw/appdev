package kr.hs.gbsw.appdev.repository;

import kr.hs.gbsw.appdev.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Modifying
    @Query("UPDATE UserEntity ue " +
            "SET ue.withdrawedYn = 'Y', ue.withdrawTime = :time " +
            "WHERE ue.userIdx = :idx ")
    void withdraw(@Param("idx") int idx, @Param("time") Date time);

}
