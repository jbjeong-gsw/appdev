package kr.hs.gbsw.appdev.controller;

import kr.hs.gbsw.appdev.domain.Writing;
import kr.hs.gbsw.appdev.service.WritingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/writing")
public class WritingController {

    private final WritingService writingService;

    @GetMapping("")
    public Page<Writing> list(@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber) {
        return writingService.list(pageNumber);
    }

}
