package kr.hs.gbsw.appdev.service;

import kr.hs.gbsw.appdev.domain.Writing;
import kr.hs.gbsw.appdev.entity.WritingEntity;
import org.springframework.data.domain.Page;

public interface WritingService {

    public Page<Writing> list(int pageNumber);

}
