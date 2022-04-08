package com.example.jwt.service;

import com.example.jwt.advice.exception.LoginFailureException;
import com.example.jwt.advice.exception.MemberEmailAlreadyExistsException;
import com.example.jwt.config.security.jwt.JwtTokenProvider;
import com.example.jwt.dao.Member;
import com.example.jwt.dto.MemberLoginRequestDto;
import com.example.jwt.dto.MemberLoginResponseDto;
import com.example.jwt.dto.MemberRegisterRequestDto;
import com.example.jwt.dto.MemberRegisterResponseDto;
import com.example.jwt.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true) // 성능 향삭을 위해 트랜잭션을 익기 전용 모드로 설정 -> 강제로 flush 를 실행하지 않는 한 flush 가 일어나지 않는다.
@RequiredArgsConstructor
public class SignService {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder; // 비밀번호 암호화를 위해 DI

    private final MemberRepository memberRepository;

    @Transactional
    public MemberRegisterResponseDto registerMember(MemberRegisterRequestDto request) {
        validateDuplicated(request.getEmail());

        Member member = memberRepository.save(
                Member.builder()
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build()
        );

        return new MemberRegisterResponseDto(member.getId(), member.getEmail());
    }

    /**
     * Unique한 값을 가져야하나, 중복된 값을 가질 경우를 검증
     */
    public void validateDuplicated(String email) {
        if (memberRepository.findByEmail(email).isPresent()) {
            throw new MemberEmailAlreadyExistsException();
        }
    }

    /**
     * 로그인 성공 시 JwtToken 생성하여 넘겨줌
     */
    public MemberLoginResponseDto loginMember(MemberLoginRequestDto request) {
        // 회원 조회
        Member member = memberRepository.findByEmail(request.getEmail()).orElseThrow(LoginFailureException::new);

        // check password
        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new LoginFailureException();
        }

        return MemberLoginResponseDto.builder()
                .id(member.getId())
                .token(jwtTokenProvider.createToken(request.getEmail()))
                .build();
    }
}
