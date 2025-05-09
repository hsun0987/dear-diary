package com.example.diaryapp;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Diary {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private LocalDate date;
}
