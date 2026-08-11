package com.interview.practice.lld.splitwise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    private final String id;
    private final String name;
    private final List<User> members = new ArrayList<>();

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addMember(User user) {
        if (!members.contains(user)) {
            members.add(user);
        }
    }

    public List<User> getMembers() {
        return Collections.unmodifiableList(members);
    }
}
