package com.example.bookmanager.domain;


import com.example.bookmanager.domain.listener.Auditable;
import com.example.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@Table(indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@EntityListeners(value = UserEntityListener.class)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

//    @Column(updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @Column(insertable = false)
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> address;

    @Transient
    private String testData;

//    @PrePersist
//    public void prePersist() {
//        System.out.println(">>> PrePersist");
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }

    @PostPersist
    public void postPersist() {
        System.out.println(">>> PostPersist");
    }

//    @PreUpdate
//    public void preUpdate() {
//        System.out.println(">>> PreUpdate");
//        this.updatedAt = LocalDateTime.now();
//    }

    @PostUpdate
    public void postUpdate() {
        System.out.println(">>> PostUpdate");
    }

    @PreRemove
    public void preRemove() {
        System.out.println(">>> PreRemove");
    }

    @PostRemove
    public void postRemove() {
        System.out.println(">>> PostRemove");
    }

    @PostLoad
    public void postLoad() {
        System.out.println(">>> PostLoad");
    }
}

