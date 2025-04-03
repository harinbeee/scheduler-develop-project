package com.example.schedulerproject.repository;

import com.example.schedulerproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername (String username);
    User findUserByMail(String mail);


    default User findUserByUsernameOrElseThrow(String username) {

        return findUserByUsername(username).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 유저 이름 = " + username));
    }

    default User findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 id="+id));
    }
}
