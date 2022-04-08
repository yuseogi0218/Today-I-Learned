package com.example.jwt.dao;

import javax.persistence.*;

import com.example.jwt.dao.type.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    // 여러개의 Role을 가질 수 있음
    @ElementCollection(fetch = FetchType.EAGER) // Role Embedded
    @Enumerated(EnumType.STRING) // Enum Type String 으로 저장
    private List<Role> roles = new ArrayList<>();

    @Builder
    public Member(String email, String password, List<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public void addRole(Role role) {

    }
}
