package br.com.uldemy.api.service;

import br.com.uldemy.api.model.User;

public interface UserService {

    User findById(Integer id);
}
