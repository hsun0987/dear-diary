package com.example.diaryapp;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DiaryService {
    private final List<Diary> diaries = new ArrayList<>();
    private Long idCounter = 1L;

    // 등록
    public Diary createDiary(Diary diary){
        diary.setId(idCounter++);
        diaries.add(diary);
        return diary;
    }

    // 목록 조회
    public List<Diary> getAllDiaries(){
        return diaries;
    }

    // 상세 조회
    public Diary getDiary(Long id){
        return diaries.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Diary not found"));
    }

    // 수정
    public Diary updateDiary(Long id, Diary updatedDiary){
        Diary diary = getDiary(id);
        diary.setTitle(updatedDiary.getTitle());
        diary.setDate(updatedDiary.getDate());
        return diary;
    }

    // 삭제
    public void deleteDiary(Long id){
        diaries.removeIf(d -> d.getId().equals(id));
    }
}
