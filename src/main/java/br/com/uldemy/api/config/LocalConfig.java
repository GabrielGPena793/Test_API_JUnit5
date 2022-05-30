package br.com.uldemy.api.config;

import br.com.uldemy.api.model.User;
import br.com.uldemy.api.repositories.UserRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepsitory userRepsitory;

    @Bean
    public void startDB(){
        User u1 = new User(null, "Gabriel","gabriel@hotmail.com", "123" );
        User u2 = new User(null, "Karla","Karla@hotmail.com", "123" );

        userRepsitory.saveAll(Arrays.asList(u1,u2));
    }

}
