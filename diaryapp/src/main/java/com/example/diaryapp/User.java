package com.example.diaryapp;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String nickname;
}
