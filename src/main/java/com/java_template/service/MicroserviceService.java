package com.java_template.service;

import com.java_template.entities.User;
import com.java_template.dto.UserDTO;
import com.java_template.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Service
public class MicroserviceService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public ResponseEntity<String> createUser(UserDTO createUser){

            User saveToDB = new User();
            saveToDB.setName(createUser.getName());
            saveToDB.setAge(createUser.getAge());
        try {
            User something = userRepository.save(saveToDB);
            System.out.println(something);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("User created in our database successfully! " );
        }
        catch(ArithmeticException e){
            System.out.println("--- error ----");
            System.out.println(e);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("There's some problem with your request. " );
        }

    }
}
