package com.rbbr.hemoglobin.dto;

import com.rbbr.hemoglobin.entity.Token;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TokenDTO {
    private String token;
    private String userType;
    private Long userId;
    private LocalDateTime expirationDate;

    public TokenDTO(Token token) {
        this.token = token.getId();
        this.userType = token.getUserType();
        this.userId = token.getUser().getId();
        this.expirationDate = token.getExpirationDate();
    }
}
