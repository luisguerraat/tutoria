package com.reto.webtutoria.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.webtutoria.CrudRepository.UserCrudRepository;
import com.reto.webtutoria.Entidades.User;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public User addUser(User user) {
        return userCrudRepository.save(user);
    }

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public boolean getValidarEmail(String email) {
        Optional<User> miusuario = userCrudRepository.findByEmail(email);

        if (miusuario.isEmpty())
            return false;
        else
            return true;
    }

    public User getLogin(String email, String password) {
        Optional<User> miusuario = userCrudRepository.findByEmailAndPassword(email, password);
        User mirespuesta = new User();

        if (miusuario.isEmpty()) {
            mirespuesta.setEmail(email);
            mirespuesta.setPassword(password);
            mirespuesta.setName("NO DEFINIDO");
        }
        else
            mirespuesta = miusuario.get();

        return mirespuesta;
    }

    
    
}
