package kr.hs.gbsw.appdev.repository;

import kr.hs.gbsw.appdev.entity.WritingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WritingRepository extends JpaRepository<WritingEntity, Integer> {

    public Page<WritingEntity> findAllByTitleContaining(Pageable pageable, String title);

    public Page<WritingEntity> findAllByTitleContainingOrContentContaining(
            Pageable pageable, String title, String content);
}
