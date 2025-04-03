package com.example.schedulerproject.repository;

import com.example.schedulerproject.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    default Schedule findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 유저 ID = " +id));
    }
}
