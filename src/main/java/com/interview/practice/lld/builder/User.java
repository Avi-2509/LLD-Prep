package com.interview.practice.lld.builder;

public class User {
    private String name;
    private String age;
    private String city;

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public User(UserBuilder ub){
        this.name = ub.name;
        this.age = ub.age;
        this.city = ub.city;
    }

    public static class UserBuilder{
        private String name;
        private String age;
        private String city;

        public UserBuilder setName(String name){
            this.name = name;
            return this;
        }

        public UserBuilder setAge(String age){
            this.age = age;
            return this;
        }

        public UserBuilder setCity(String city){
            this.city = city;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

}
