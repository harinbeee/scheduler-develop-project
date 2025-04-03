package com.example.schedulerproject.service;

import com.example.schedulerproject.dto.ScheduleResponseDto;
import com.example.schedulerproject.entity.Schedule;
import com.example.schedulerproject.entity.User;
import com.example.schedulerproject.repository.ScheduleRepository;
import com.example.schedulerproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

//    **의존성 주입**
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    // 1. 게시물 생성
    public ScheduleResponseDto save(String title, String description, String username) {

        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

        Schedule schedule =  new Schedule(title, description);
        schedule.setUser(findUser);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getDescription());
    }

    // 2. 게시물 조회

    // 3. 게시물 수정

    // 4. 게시물 삭제

}
