package kr.hs.gbsw.appdev.bean.callback;

import org.slf4j.LoggerFactory;

public class CallbackBeanByConfiguration {
    public void prepare() throws Exception {
        LoggerFactory.getLogger(getClass()).info("CallbackBeanByConfiguration Bean의 prepare 호출됨");
    }

    public void clear() throws Exception {
        LoggerFactory.getLogger(getClass()).info("CallbackBeanByConfiguration Bean의 clear 호출됨");
    }
}
