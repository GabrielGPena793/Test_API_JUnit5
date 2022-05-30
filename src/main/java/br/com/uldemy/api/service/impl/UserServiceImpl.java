package br.com.uldemy.api.service.impl;

import br.com.uldemy.api.model.User;
import br.com.uldemy.api.repositories.UserRepsitory;
import br.com.uldemy.api.service.UserService;
import br.com.uldemy.api.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepsitory repsitory;

    @Override
    public User findById(Integer id) {

        Optional<User> userModel = repsitory.findById(id);

        return userModel.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
