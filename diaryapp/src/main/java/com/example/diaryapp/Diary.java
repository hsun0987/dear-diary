package com.example.diaryapp;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Diary {
    private Long id;
    private String title;
    private String content;
    private LocalDate date;

    public Diary(LocalDate date, Long id, String title, String content) {
        this.date = date;
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
