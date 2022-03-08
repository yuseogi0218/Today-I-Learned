package com.example.securityLogin.service;

import com.example.securityLogin.domain.User;
import com.example.securityLogin.dto.UserLoginReq;
import com.example.securityLogin.dto.UserLoginRes;
import com.example.securityLogin.dto.UserSignUpReq;
import com.example.securityLogin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void signUp(UserSignUpReq userSignUpReq) {
        User user = new User();
        user.setLoginId(userSignUpReq.getLoginId());
        user.setLoginPw(passwordEncoder.encode(userSignUpReq.getLoginPw()));
        user.setName(userSignUpReq.getName());

        System.out.println(user);

        userRepository.save(user);
    }

    public UserLoginRes login(UserLoginReq userLoginReq) {
        User target_user = userRepository.findByLoginId(userLoginReq.getLoginId());

        if (passwordEncoder.matches(userLoginReq.getLoginPw(), target_user.getLoginPw())) {
            return new UserLoginRes(target_user.getName());
        }else {
            throw new RuntimeException();
        }
    }
}
