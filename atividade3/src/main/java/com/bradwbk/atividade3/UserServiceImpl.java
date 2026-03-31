package com.bradwbk.atividade3;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();

    @Override
    public void add(User newUser) {
        users.add(newUser);
    }

    @Override
    public User find(String login) {
        return users.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean remove(String login) {
        return users.removeIf(u -> u.getLogin().equals(login));
    }
}