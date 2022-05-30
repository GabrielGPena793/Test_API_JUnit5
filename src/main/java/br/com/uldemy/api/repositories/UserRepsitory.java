package br.com.uldemy.api.repositories;

import br.com.uldemy.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepsitory extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

}
