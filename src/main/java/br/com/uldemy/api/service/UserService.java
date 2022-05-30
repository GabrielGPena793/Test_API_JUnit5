package br.com.uldemy.api.service;

import br.com.uldemy.api.model.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
}
