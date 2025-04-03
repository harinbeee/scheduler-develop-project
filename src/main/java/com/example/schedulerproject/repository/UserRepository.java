package com.example.schedulerproject.repository;

import com.example.schedulerproject.entity.User;
import com.example.schedulerproject.exception.UserNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername (String username);
    User findUserByMail(String mail);


    default User findUserByUsernameOrElseThrow(String username) {

        return findUserByUsername(username).orElseThrow(()-> new UserNotFoundException());
    }

    default User findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(()-> new UserNotFoundException());
    }
}
