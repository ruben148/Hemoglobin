package com.rbbr.hemoglobin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "token")
@Getter @Setter @NoArgsConstructor
public class Token {
    @Id
    private String Id;
    private LocalDateTime expirationDate;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String userType;
    public Token(LocalDateTime expirationDate, User user, String userType) {
        this.Id = java.util.UUID.randomUUID().toString();
        this.expirationDate = expirationDate;
        this.user = user;
        this.userType = userType;
    }
}