package com.mp.mainproject.db.entity;

import com.mp.mainproject.core.base.BaseEntity;
import com.mp.mainproject.db.entity.enums.SocialProvider;
import com.mp.mainproject.db.entity.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11)", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "user_name", columnDefinition = "varchar(50)", nullable = false)
    private String userName;

    @Size(max = 10)
    @Enumerated(EnumType.STRING)
    @Column(name = "social_type", columnDefinition = "varchar(10)", nullable = false)
    private SocialProvider socialType;

    @Size(max = 255)
    @NotNull
    @Column(name = "social_id", columnDefinition = "varchar(255)", nullable = false)
    private String socialId;

    @Size(max = 10)
    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", columnDefinition = "varchar(10) default 'ACTIVE'", nullable = false)
    private UserStatus userStatus;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<FcmToken> fcmTokenEntities = new ArrayList<>();
}
