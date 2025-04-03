package com.example.schedulerproject.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {
    // 필터를 거치지 않을 URI 상수로 등록
    private static final String[] WHITE_LIST = {"/", "/users/signup", "/users/login"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        log.info("로그인 필터 로직 실행");

        // 로그인을 체크해야하는 URL인지 검사
        // WHITE LIST에 포함된 경우 = true -> 로그인 체크 필요 없으니 !로 반대
        if (!isWhiteList(requestURI)) {

            // 로그인 확인 로직
            HttpSession session = httpRequest.getSession(false);

            // 로그인 하지 않은 경우 예외 로직
            if (session == null || session.getAttribute("loginUser") == null ) {
                throw new RuntimeException("로그인 해주세요.");
            }

            // 로그인 성공 로직
            log.info("로그인에 성공했습니다.");

        }
        chain.doFilter(request, response);

    }

    // 요청 URI이 WHITE LIST인지 체크하는 메서드
    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}