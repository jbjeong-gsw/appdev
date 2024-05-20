package kr.hs.gbsw.appdev.service;

import kr.hs.gbsw.appdev.domain.User;

public interface UserService {

    /**
     * 사용자를 등록한다.
     *
     * @param user 추가될 사용자 정보
     * @return 데이터베이스에 추가된 사용자 정보
     */
    User add(User user);

    /**
     * 사용자 정보를 읽어온다.
     *
     * @param idx 사용자 idx
     * @return 사용자 정보
     */
    User get(int idx);

    User get(String email);

    User update(User user);

    void remove(int userIdx);

}
