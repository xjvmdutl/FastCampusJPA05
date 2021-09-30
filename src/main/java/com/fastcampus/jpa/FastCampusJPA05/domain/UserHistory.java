package com.fastcampus.jpa.FastCampusJPA05.domain;

import com.fastcampus.jpa.FastCampusJPA05.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)//toString 재정의
@EqualsAndHashCode(callSuper = true)
public class UserHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String email;

    @ManyToOne
    private User user;


}
