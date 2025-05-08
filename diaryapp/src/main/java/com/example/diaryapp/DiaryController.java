package com.example.diaryapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diaries")
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService){
        this.diaryService = diaryService;
    }

    @PostMapping
    public Diary createDiary(@RequestBody Diary diary){
        return diaryService.createDiary(diary);
    }

    @GetMapping
    public List<Diary> getAllDiaries(){
        return diaryService.getAllDiaries();
    }

    @GetMapping("/{id}")
    public Diary getDiary(@PathVariable Long id){
        return diaryService.getDiary(id);
    }

    @PutMapping("/{id}")
    public Diary updateDiary(@PathVariable Long id, @RequestBody Diary diary){
        return diaryService.updateDiary(id, diary);
    }

    @DeleteMapping("/{id}")
    public void deleteDiary(@PathVariable Long id){
        diaryService.deleteDiary(id);
    }
}
