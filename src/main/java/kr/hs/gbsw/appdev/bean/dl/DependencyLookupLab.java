package kr.hs.gbsw.appdev.bean.dl;


import jakarta.annotation.PostConstruct;
import kr.hs.gbsw.appdev.bean.MyBean;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


//@Component
@RequiredArgsConstructor
public class DependencyLookupLab {
    private ObjectProvider<Date> dateObjectProvider;

    @PostConstruct
    public void testDL() {
        Date date = dateObjectProvider.getObject("independenceDayOfKorea");

        LoggerFactory.getLogger(getClass()).info("Date of DL - {}", new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

}
