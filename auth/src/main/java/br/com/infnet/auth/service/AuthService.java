package br.com.infnet.auth.service;

import br.com.infnet.auth.model.User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {
    Map<String , User> usersMap = Map.of(
            "jennifer", User.builder().id(1L).username("jennifer").password("123").build(),
            "marta", User.builder().id(2L).username("marta").password("123").build()
    );

    public User autenticar(User user) {
        User userDB = usersMap.get(user.getUsername());
        if(userDB != null) {
            if(!userDB.getPassword().equals(user.getPassword())) return null;
        }
        return userDB;
    }
}
