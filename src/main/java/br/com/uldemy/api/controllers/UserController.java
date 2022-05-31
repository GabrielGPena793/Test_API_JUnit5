package br.com.uldemy.api.controllers;

import br.com.uldemy.api.model.dto.UserDTO;
import br.com.uldemy.api.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    public static final String ID = "/{id}";
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserService service;

    @GetMapping(ID)
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll().stream().map(user -> mapper.map(user, UserDTO.class)).toList());
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path(ID).buildAndExpand(service.create(userDTO).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(ID)
    public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        userDTO.setId(id);
        return ResponseEntity.ok().body(mapper.map(service.update(userDTO), UserDTO.class));
    }

    @DeleteMapping(ID)
    public ResponseEntity<UserDTO> delete(@PathVariable Integer id){
        findById(id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
