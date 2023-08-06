package com.reto.webtutoria.Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;

   /*
   id (PK)AUTO_INCREMENTint(11) Not null.

user_email (Unique Index)varchar(50) Not null.

user_namevarchar(80) Not null.

user_passwordvarchar(50) Not null. 
   
   */
    
    @NotNull
    @Size(max = 50)
    @Column(unique = true, name = "user_email")
    private String email;

    @NotNull
    @Size(max = 50)
    @Column( name = "user_password")
    private String password;

    @NotNull
    @Size(max = 80)
    @Column( name = "user_name")
    private String name;

    

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    
    
}
