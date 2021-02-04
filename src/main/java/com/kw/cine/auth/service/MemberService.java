package com.kw.cine.auth.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kw.cine.auth.domain.Role;
import com.kw.cine.auth.domain.entity.MemberEntity;
import com.kw.cine.auth.domain.repository.MemberRepository;
import com.kw.cine.auth.dto.MemberDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
	
	private MemberRepository memberRepository;
	
	// 회원 등록
	@Transactional
    public Long joinUser(MemberDto memberDto) {
        // 비밀번호 암호화
               BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        return memberRepository.save(memberDto.toEntity()).getId();
    }
	

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(userEmail);
        MemberEntity userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@example.com").equals(userEmail)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        }
        
        if (("skarhs1234@gmail.com").equals(userEmail)) {
        	authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        }

        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
    }
    
    // 관리자 비밀번호 변경
    @Transactional
    public Long updateUser(String userEmail, String userPwd) {
    	MemberEntity member = memberRepository.findByEmail(userEmail).get(); // 이메일로 member 객체 찾고
    	MemberDto memberDto = MemberDto.builder() // memberDto 집력해주고
    			.id(member.getId()).email(member.getEmail()).password(userPwd).build(); // 새로운 비밀번호로
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
    	
    	return memberRepository.save(memberDto.toEntity()).getId();
    }
    
    public boolean userEmailCheck(String userEmail) {

        MemberEntity member = memberRepository.findByEmail(userEmail).get();
        if(member != null) return true;
        else return false;
    }
    

}
