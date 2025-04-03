package com.example.schedulerproject.repository;

import com.example.schedulerproject.entity.Schedule;
import com.example.schedulerproject.exception.ScheduleNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    default Schedule findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(()->
                new ScheduleNotFoundException());
    }
}
