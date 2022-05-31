package br.com.uldemy.api.controllers;

import br.com.uldemy.api.model.User;
import br.com.uldemy.api.model.dto.UserDTO;
import br.com.uldemy.api.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {

    public static final Integer ID                              = 1;
    public static final String NAME                             = "Gabriel";
    public static final String EMAIL                            = "gabriel@hotmail.com";
    public static final String PASSWORD                         = "123";
    public static final String OBJETO_NAO_ENCONTRADO            = "Objeto não encontrado";
    public static final String E_MAIL_JA_CADASTRADO_NO_SISTEMA  = "E-mail já cadastrado no sistema";
    public static final int INDEX                               = 0;

    @InjectMocks
    private UserController controller;

    @Mock
    private ModelMapper mapper;
    @Mock
    private UserService service;

    private User user;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
    }
}