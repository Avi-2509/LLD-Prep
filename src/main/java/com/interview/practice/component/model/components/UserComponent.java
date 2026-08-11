package com.interview.practice.component.model.components;

import com.interview.practice.component.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserComponent {


    public void createUser(User user){
        log.info(user.getName());
    }
}
