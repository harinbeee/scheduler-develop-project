# 📌 일정 관리 앱 프로젝트 - Develop
일정 관리 앱 Develop 프로젝트는 사용자 인증 기반의 개인 일정 등록 및 관리 기능을 제공합니다.
**회원가입 및 로그인 후**, 일정 등록/수정/삭제/조회 기능을 통해 일정을 관리할 수 있습니다.

<br>

## ⚙️ 개발 환경
- Java : 17 
- JDK : 17.0.1
- Spring Boot : 3.4.4
- IDE : IntelliJ
- Build Tool : Gradle 
- API Test : Postman
  
<br>

## 📑 [API 명세서](https://documenter.getpostman.com/view/43200298/2sB2cU9Mng)
( ↳ 실행 예시까지 자세히 보기 )
| 기능 | Method | URL | 요청(Request) | 응답(Response) | 상태 코드 |
|------|--------|-----|--------------|----------------|-------------|
| 🔐 로그인 | POST | `/users/login` | `mail`, `password` | - | `200 OK` |
| 🧑 회원가입 | POST | `/users/signup` | `username`, `mail`, `password` | 생성된 유저 정보 | `201 CREATED` |
| 👤 유저 조회 | GET | `/users/{userId}` | - | 유저 정보 | `200 OK` |
| ✏️ 유저 수정 | PATCH | `/users/{userId}` | `username`, `mail`, `password` | - | `200 OK` |
| ❌ 유저 삭제 | DELETE | `/users/{userId}` |  `password` | - | `200 OK` |
| 📝 일정 생성 | POST | `/schedules` | `title`, `description`, `user`, `password` | 생성된 일정 정보 | `201 CREATED` |
| 📋 전체 일정 조회 | GET | `/schedules` | - | 일정 목록 | `200 OK` |
| 🛠️ 일정 수정 | PATCH | `/schedules/{scheduleId}` |  `title`, `description`, `user`, `password` | 수정된 일정 정보 | `200 OK` |
| 🗑️ 일정 삭제 | DELETE | `/schedules/{scheduleId}` |  `password` | - | `200 OK` |

<br>

## 🔖 [ERD](https://github.com/user-attachments/assets/ee0e96d1-ceec-41ef-98bc-188a381469ab)

