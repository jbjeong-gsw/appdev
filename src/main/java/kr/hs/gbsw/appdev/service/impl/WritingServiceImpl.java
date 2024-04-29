package kr.hs.gbsw.appdev.service.impl;

import kr.hs.gbsw.appdev.domain.Writing;
import kr.hs.gbsw.appdev.entity.WritingEntity;
import kr.hs.gbsw.appdev.repository.WritingRepository;
import kr.hs.gbsw.appdev.service.WritingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WritingServiceImpl implements WritingService {

    private final WritingRepository writingRepository;

    @Override
    public Page<Writing> list(int pageNumber) {
        Sort sort = Sort.by(Sort.Direction.DESC, "writingIdx");
        Pageable pageable = PageRequest.of(pageNumber, 10, sort);

        Page<WritingEntity> page = writingRepository.findAll(pageable);
        return page.map(Writing::toDomain);
    }
}
