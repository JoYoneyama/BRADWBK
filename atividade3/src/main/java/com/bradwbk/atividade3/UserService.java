package com.bradwbk.atividade3;

public interface UserService {

    void add(User newUser);

    User find(String login);

    boolean remove(String login);
}