package com.example.schedulerproject.service;

import com.example.schedulerproject.dto.ScheduleResponseDto;
import com.example.schedulerproject.entity.Schedule;
import com.example.schedulerproject.entity.User;
import com.example.schedulerproject.exception.InvalidPasswordException;
import com.example.schedulerproject.exception.ScheduleNotFoundException;
import com.example.schedulerproject.repository.ScheduleRepository;
import com.example.schedulerproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

//    **의존성 주입**
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;


    // 1. 스케줄 생성
    public ScheduleResponseDto saveSchedule(String title, String description, String username) {
        // 유저 이름으로 유저 찾기
        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

        Schedule schedule =  new Schedule(title, description);
        schedule.setUser(findUser);

        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getId(), findUser.getUsername(), savedSchedule.getTitle(), savedSchedule.getDescription());
    }

    // 2. 스케줄 조회
    public List<ScheduleResponseDto> findAllSchedule() {
        List<Schedule> schedules = scheduleRepository.findAll();

        if(schedules.isEmpty()){
            throw new ScheduleNotFoundException();
        }

        return schedules
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    // 3. 스케줄 수정
    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, String title, String description, String password) {

        // 스케줄 찾기
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        // 비밀번호 확인 - id로 유저찾기
        User findUser = userRepository.findByIdOrElseThrow(id);
        // 비밀번호 확인 - 예외 처리
        if(!findUser.getPassword().equals(password)){
            throw new InvalidPasswordException();
        }

        // 수정 전 내용 저장해두기
        String updatedTitle = (title != null) ? title : schedule.getTitle();
        String updatedDescription = (description != null) ? description : schedule.getDescription();

        // 수정한 내용 업데이트
        schedule.update(updatedTitle, updatedDescription);
        return new ScheduleResponseDto(schedule.getId(), findUser.getUsername(),schedule.getTitle(),schedule.getDescription());
    }

    // 4. 스케줄 삭제
    public void deleteSchedule(Long id, String password) {
        // 스케줄 찾기
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        // 비밀번호 확인 - id로 유저찾기
        User findUser = userRepository.findByIdOrElseThrow(id);
        // 비밀번호 확인 - 예외 처리
        if(!findUser.getPassword().equals(password)){
            throw new InvalidPasswordException();
        }

        scheduleRepository.delete(schedule);



    }


}
