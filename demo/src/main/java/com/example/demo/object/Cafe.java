package com.example.demo.object;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private int id;
    private String name;
    private List<Integer> key_cnt = new ArrayList<>();
    private List<List<String>> key_example = new ArrayList<>();

    public List<Integer> getKey_cnt() {
        return key_cnt;
    }

    public void setKey_cnt(List<Integer> key_cnt) {
        this.key_cnt = key_cnt;
    }

    public List<List<String>> getKey_example() {
        return key_example;
    }

    public void setKey_example(List<List<String>> key_example) {
        this.key_example = key_example;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
/*
    cafe1 = [
        [0, "A의 조용함 대표문장 1", 0],
        [0, "A의 조용함 대표문장 2", 0],
        [0, "A의 조용함 대표문장 3", 0],
        [0, "A의 공부하기좋은분위기 대표문장 1", 1],
        [0, "A의 공부하기좋은분위기 대표문장 2", 1],
        [0, "A의 공부하기좋은분위기 대표문장 3", 1],
        [0, "A의 콘센트이용 대표문장 1", 2],
        [0, "A의 콘센트이용 대표문장 2", 2],
        [0, "A의 콘센트이용 대표문장 3", 2]
        ]
        cafe_list = [
        [0, "A", "카페 A의 주소", 11, 21, 31, 41, 51, 61],
        [1, "B", "카페 B의 주소", 12, 22, 32, 42, 52, 62],
        [2, "C", "카페 C의 주소", 13, 23, 33, 43, 53, 63]
        ]*/