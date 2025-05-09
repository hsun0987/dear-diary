package com.example.diaryapp;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DiaryService {
    private final List<Diary> diaries = new ArrayList<>();
    private Long idCounter = 1L;
    private final UserService userService;

    public DiaryService(UserService userService) {
        this.userService = userService;

        // 가데이터 추가
        Diary diary1 = new Diary();
        diary1.setId(idCounter++);
        diary1.setTitle("첫 번째 일기");
        diary1.setContent("오늘은 날씨가 좋았어요.");
        diary1.setDate(java.time.LocalDate.now());
        diaries.add(diary1);

        Diary diary2 = new Diary();
        diary2.setId(idCounter++);
        diary2.setTitle("두 번째 일기");
        diary2.setContent("스프링 부트 공부를 시작했어요.");
        diary2.setDate(java.time.LocalDate.now().minusDays(1));
        diaries.add(diary2);
    }

    // 등록
    public Diary createDiary(Diary diary, Long userId){
        // 사용자 존재 확인
        userService.getUser(userId);

        diary.setId(idCounter++);
        diaries.add(diary);
        return diary;
    }

    // 목록 조회
    public List<Diary> getAllDiaries(){
        return diaries;
    }

    // 특정 사용자의 일기 목록 조회
    public List<Diary> getDiariesByUserId(Long userId){
        return diaries.stream()
                .filter(d -> Objects.equals(userId, d.getUserId()))
                .toList();
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
