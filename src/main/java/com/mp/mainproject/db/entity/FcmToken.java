package com.mp.mainproject.db.entity;

import com.mp.mainproject.core.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "fcm_tokens")
@Entity
@IdClass(FcmTokenId.class)
public class FcmToken extends BaseEntity {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Size(max = 255)
    @Id
    @Column(name = "token", columnDefinition = "VARCHAR(255)", nullable = false, updatable = false)
    private String token;

    @MapsId("user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}

