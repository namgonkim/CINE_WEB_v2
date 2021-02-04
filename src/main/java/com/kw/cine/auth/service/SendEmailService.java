package com.kw.cine.auth.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kw.cine.auth.domain.entity.MemberEntity;
import com.kw.cine.auth.domain.repository.MemberRepository;
import com.kw.cine.auth.dto.MailDto;
import com.kw.cine.auth.dto.MemberDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SendEmailService{

    @Autowired
    MemberRepository memberRepository;

    private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "skarhs1234@gmail.com";



    public MailDto createMailAndChangePassword(String userEmail){
        String str = getTempPassword();
        MailDto dto = new MailDto();
        dto.setAddress(userEmail);
        dto.setTitle(userEmail+"님의 HOTTHINK 임시비밀번호 안내 이메일 입니다.");
        dto.setMessage("안녕하세요. HOTTHINK 임시비밀번호 안내 관련 이메일 입니다." + "[" + userEmail + "]" +"님의 임시 비밀번호는 "
        + str + " 입니다.");
        updatePassword(str,userEmail);
        return dto;
    }

    @Transactional
    public void updatePassword(String str,String userEmail){ // str은 임시 비밀번호, 
    	MemberEntity member = memberRepository.findByEmail(userEmail).get(); // 이메일로 member 객체 찾고
    	MemberDto memberDto = MemberDto.builder() // memberDto 집력해주고
    			.id(member.getId()).email(member.getEmail()).password(str).build(); // 새로운 비밀번호로
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
    	memberRepository.save(memberDto.toEntity()).getId();
    }


    public String getTempPassword(){
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }
    
    public void mailSend(MailDto mailDto){
        System.out.println("이멜 전송 완료!");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getAddress());
        message.setFrom(SendEmailService.FROM_ADDRESS);
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMessage());

        mailSender.send(message);
    }
}