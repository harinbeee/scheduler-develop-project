package com.example.schedulerproject.controller;

import com.example.schedulerproject.dto.*;
import com.example.schedulerproject.service.ScheduleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

//    **의존성 주입**
    private final ScheduleService scheduleService;

    // 1. 스케줄 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> saveSchedule(
            @RequestBody ScheduleRequestDto requestDto,
            HttpServletRequest request
    ){
        // 로그인 세션 불러오기
        HttpSession session = request.getSession(false);
        UserResponseDto loginUser = (UserResponseDto) session.getAttribute("loginUser"); // 다운캐스팅!!

        // 유저네임은 가져오기
        ScheduleResponseDto scheduleResponseDto =
                scheduleService.saveSchedule(requestDto.getTitle(), requestDto.getDescription(), loginUser.getUsername());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    // 2. 스케줄 전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule() {

        List<ScheduleResponseDto> boardResponseDto = scheduleService.findAllSchedule();

        return new ResponseEntity<>(boardResponseDto, HttpStatus.OK);
    }

    // 3. 스케줄 수정 - 비밀번호 일치시
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody UpdateScheduleRequestDto requestDto
    ) {
        ScheduleResponseDto scheduleResponseDto =
                scheduleService.updateSchedule(id, requestDto.getTitle(), requestDto.getDescription(), requestDto.getPassword());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    // 4. 스케줄 삭제 - 비밀번호 일치시
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule (
            @PathVariable Long id,
            @RequestBody DeleteRequestDto requestDto
    ) {
        scheduleService.deleteSchedule(id, requestDto.getPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
