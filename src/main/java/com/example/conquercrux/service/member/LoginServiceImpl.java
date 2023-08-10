package com.example.conquercrux.service.member;

import com.example.conquercrux.mapper.member.LoginMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private LoginMapper loginMapper;

    @Override
    public boolean checkCredentials(String member_id, String member_password) {
        log.info("MemberService.updateMember");

        return loginMapper.checkCredentials(member_id, member_password);
    }
}
