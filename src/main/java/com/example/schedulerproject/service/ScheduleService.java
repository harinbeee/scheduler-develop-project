package com.example.schedulerproject.service;

import com.example.schedulerproject.dto.ScheduleResponseDto;
import com.example.schedulerproject.entity.Schedule;
import com.example.schedulerproject.entity.User;
import com.example.schedulerproject.repository.ScheduleRepository;
import com.example.schedulerproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

//    **의존성 주입**
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    // 1. 스케줄 생성
    public ScheduleResponseDto save(String title, String description, String username) {

        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

        Schedule schedule =  new Schedule(title, description);
        schedule.setUser(findUser);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getDescription());
    }

    // 2. 스케줄 조회
    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    // 3. 스케줄 수정

    // 4. 스케줄 삭제

}
