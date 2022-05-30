package br.com.uldemy.api.service;

import br.com.uldemy.api.model.User;
import br.com.uldemy.api.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO userDTO);
    User update(UserDTO userDTO);
}
