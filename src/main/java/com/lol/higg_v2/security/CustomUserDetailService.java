package com.lol.higg_v2.security;

import com.lol.higg_v2.entity.HiggMember;
import com.lol.higg_v2.repository.HiggMemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private HiggMemberRepository higgMemberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info(" >>>>> loadUserByUsername => " + username);

        Optional<HiggMember> result = higgMemberRepository.findByUid(username);

        if(result.isEmpty()){
            throw new UsernameNotFoundException("회원의 아이디 또는 비밀번호 확인");
        }

        // 회원의 정보, 권한 정보 => CustomUser 인스턴스 생성 반환
        HiggMember higgMember = result.get();

        log.info("@@@@@@@@@@@@" + higgMember);

        // 권한 데이터 처리
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(
                new SimpleGrantedAuthority("ROLE_" + higgMember.getRole()));

        CustomMember user = new CustomMember(
                higgMember.getUid(),
                higgMember.getPw(),
                authorities
        );

        return user;
    }

}
