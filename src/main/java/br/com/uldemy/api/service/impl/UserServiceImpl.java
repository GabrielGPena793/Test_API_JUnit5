package br.com.uldemy.api.service.impl;

import br.com.uldemy.api.model.User;
import br.com.uldemy.api.model.dto.UserDTO;
import br.com.uldemy.api.repositories.UserRepsitory;
import br.com.uldemy.api.service.UserService;
import br.com.uldemy.api.service.exceptions.DataIntegratyViolationException;
import br.com.uldemy.api.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserRepsitory repsitory;

    @Override
    public User findById(Integer id) {
        Optional<User> userModel = repsitory.findById(id);
        return userModel.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<User> findAll(){
        return repsitory.findAll();
    }

    @Override
    public User create(UserDTO userDTO) {
        findByEmail(userDTO);
        return repsitory.save(mapper.map(userDTO, User.class));
    }

    @Override
    public User update(UserDTO userDTO) {
       return create(userDTO);
    }

    @Override
    public void delete(Integer id) {
        repsitory.deleteById(id);
    }

    private void findByEmail(UserDTO userDTO){
        Optional<User> user = repsitory.findByEmail(userDTO.getEmail());
        if (user.isPresent() && !user.get().getId().equals(userDTO.getId())){
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }
}
