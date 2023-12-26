package com.example.BuilderPattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        User user = User.builder().age(1).build();
    }
}