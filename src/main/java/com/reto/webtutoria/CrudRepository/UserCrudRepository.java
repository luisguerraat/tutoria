package com.reto.webtutoria.CrudRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reto.webtutoria.Entidades.User;

public interface UserCrudRepository extends CrudRepository<User, Long> {
    // Forma1

    @Query(value = "SELECT * FROM users WHERE user_email = ?",nativeQuery=true)
    public Optional<User> findbyEmail(String email);

    @Query(value="SELECT * FROM users WHERE user_email = ? and user_password = ?",nativeQuery=true)
    public Optional<User> findbyEmailandPassword(String email, String password);

    // Format2
    public Optional<User> findByEmail(String email);

    public Optional<User> findByEmailAndPassword(String email, String password);
    
}
