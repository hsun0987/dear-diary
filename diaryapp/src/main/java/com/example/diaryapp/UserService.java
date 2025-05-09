package com.example.diaryapp;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    private Long idCounter = 1L;

    // 가데이터 추가
    public UserService() {
        User user1 = new User();
        user1.setId(idCounter++);
        user1.setUsername("user1");
        user1.setPassword("password1");
        user1.setNickname("사용자1");
        users.add(user1);

        User user2 = new User();
        user2.setId(idCounter++);
        user2.setUsername("user2");
        user2.setPassword("password2");
        user2.setNickname("사용자2");
        users.add(user2);
    }

    // 회원가입
    public User registerUser(User user){
        // 중복 사용자 확인
        if (users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))){
            throw new IllegalArgumentException("Username already exists");
        }
        user.setId(idCounter++);
        users.add(user);
        return user;
    }

    // 로그인
    public User login(String username, String password){
        System.out.println("저장된 사용자 목록:");
        for (User user : users) {
            System.out.println("ID: " + user.getId() + ", Username: " + user.getUsername() + ", Password: " + user.getPassword());
        }

        return users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Invalid username or password"));
    }

    // 사용자 조회
    public User getUser(Long id){
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    // 사용자 목록 조회
    public List<User> getAllUsers(){
        return users;
    }
}