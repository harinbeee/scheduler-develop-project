package com.example.schedulerproject.service;

import com.example.schedulerproject.dto.ScheduleResponseDto;
import com.example.schedulerproject.entity.Schedule;
import com.example.schedulerproject.entity.User;
import com.example.schedulerproject.repository.ScheduleRepository;
import com.example.schedulerproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

//    **의존성 주입**
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    // 1. 스케줄 생성
    public ScheduleResponseDto saveSchedule(String title, String description, String username) {

        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

        Schedule schedule =  new Schedule(title, description);
        schedule.setUser(findUser);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getDescription());
    }

    // 2. 스케줄 조회
    public List<ScheduleResponseDto> findAllSchedule() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    // 3. 스케줄 수정
    public ScheduleResponseDto updateSchedule(Long id, String title, String description, String password) {

        // 스케줄 찾기
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        // 비밀번호 확인 - id로 유저찾기
        User findUser = userRepository.findByIdOrElseThrow(id);
        // 비밀번호 확인 - 예외 처리
        if(!findUser.getPassword().equals(password)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

         schedule.update(title, description);

        return new ScheduleResponseDto(schedule.getId(),schedule.getTitle(),schedule.getDescription());
    }



    // 4. 스케줄 삭제

}
