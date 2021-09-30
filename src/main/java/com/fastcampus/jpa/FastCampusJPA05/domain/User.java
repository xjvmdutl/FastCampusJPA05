package com.fastcampus.jpa.FastCampusJPA05.domain;

import com.fastcampus.jpa.FastCampusJPA05.domain.listener.Auditable;
import com.fastcampus.jpa.FastCampusJPA05.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@EntityListeners(value = { UserEntityListener.class})
@ToString(callSuper = true)//toString 재정의
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Builder.Default
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    @ToString.Exclude
    private List<UserHistory> userHistories = new ArrayList<>();//1,2,3,4,5,6 값을 배열 데이터

    @Builder.Default
    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();
}
