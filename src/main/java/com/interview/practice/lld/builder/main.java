package com.interview.practice.lld.builder;

public class main {
    public static void main(String[] args) {
        User user = new User.UserBuilder().setName("Avi")
                .build();

        System.out.println(user.getName());
    }
}
