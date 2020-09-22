package com.shongrimes.tabletalk.data;

import com.shongrimes.tabletalk.model.User;
import org.springframework.boot.web.servlet.server.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserData {

    private Map<String, User> userData = new HashMap<>();
    private UserRepository userRepository;

    public void addUser(User user){

        userData.put(user.getUsername(), user);
    }

    public void deleteUser(User user){

        userData.remove(user.getUsername());
    }

    public List<User> findUser(User user){

        List<User> results = new ArrayList<>();

        results.add(userData.get(user));
        return results;
    }
}
