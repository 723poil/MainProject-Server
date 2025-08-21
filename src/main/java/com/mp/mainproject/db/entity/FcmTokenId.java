package com.mp.mainproject.db.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Embeddable
public class FcmTokenId implements Serializable {

    private Integer userId;

    private String token;

    public FcmTokenId(Integer userId, String token) {
        this.userId = userId;
        this.token = token;
    }
}