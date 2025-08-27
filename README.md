# 나는야 플러팅 마스터❤
<img width="230" height="199" alt="image" src="https://github.com/user-attachments/assets/07b0cd28-c36d-4028-93b9-b034c9aa7382" />

</br>
</br>

## 1. 제작 기간 & 참여 인원
- 2025년 8월 21일 ~ 8월 27일
- 미니 프로젝트 정연팀 (정연, 서인성, 김현수, 임도형, 홍유진)

</br>

## 2. 사용 기술
### Programming Language
  - Java 11
### Database
  - Oracle

</br>

## 3. ERD 설계
<img width="671" height="163" alt="image" src="https://github.com/user-attachments/assets/c089b778-bea2-4bcc-bf7e-058ab3aaedcf" />

</br>

## 4. 핵심 기능
💕 썸녀와의 대화를 통해 호감도를 상승 시키고 고백 성공하기 💕

<details>
<summary><b>핵심 기능 설명 펼치기</b></summary>
<div markdown="1">

### 1) 진행 방식
- 회원가입 ( 프로그램 진행 시 사용할 닉네임 설정까지 작성 )
- 로그인 후 프로그램 진행 시작
- 게임 내레이션 이후 진행되는 내용에 따라 선택지 고르면서 스토리 진행
- 선택지 별 다른 포인트 ( 누적 / 차감 )
- 총 합산 포인트에 따라 다른 엔딩 출력

### 2) 플로우 차트
<img width="655" height="723" alt="image" src="https://github.com/user-attachments/assets/6fa17164-122a-43a1-a739-13176434efb2" />


### 3) 피드백 채택 의견 
" 호감도에 따른 대화 등 텍스트양이 걱정됩니다. "

--> 데이터 타입 (VARCHAR2(4000 BYTE)) 수정 후 텍스트 양 조절

</br>

" 좀더 구체적으로 게임절차가 짜여줬으면 한다. "

--> 시나리오 구성 & 선택지 작성 후 연결된 결과에 따라 다른 내용 구성

</br>

" 스토리가 길고 복잡해서  프로젝트기간내에   완성이 될수있을까? 라는 생각이 든다!! 화이팅입니다 "

--> 시나리오 장면 당 텍스트 양 설정 & 흐름 지정

</div>
</details>

</br>

## 5. 핵심 트러블 슈팅
### 5.1. 스크립트 길이에 따른 VARCHAR2 길이 변경
- 시뮬레이션 게임의 스크립트의 길이 때문에 문제가 생김
- 이슈 사항: INSERT문으로 입력시 오류
- 원인: 초기 설정한 VARCHAR2 컬럼의 데이터 길이가 예상보다 큼

<details>
<summary><b>해결 단계</b></summary>
시도1. 시도한 내용
초기 값 설정 없이 원하는 값만 입력
→ 초기 값 설정하기
String sql = "INSERT INTO GAMER (ID, PASSWORD, NICKNAME) VALUES (?, ?, ?)";

</div>
</details>
<details>
<summary><b>해결 방법</b></summary>
VARCHAR2(500) →VARCHAR2(1000) → VARCHAR2(2000) → VARCHAR2(4000)으로 변경

</div>
</details>

### 5.2. 관리자 계정 초기 값 설정
- 클래스 명: oracle - GAMER
- 원인: 데이터 타입 = NUMBER , 관리자의 초기 값 = null
- 이슈 사항 : 쿼리문으로 가져온 컬럼 값이 자료형이 Number인데도 null이라서 자바에서 비교연산이 불가

<details>
<summary><b>해결 단계</b></summary>
- **시도1. 시도한 내용**
    - null값인 경우 관리자로 분류하도록 작성
    - getInt 메서드와 null이 비교 연산이 불가

</div>
</details>

<details>
<summary><b>해결 방법</b></summary>
관리자의 초기 값 = -1 로 설정

</div>
</details>

### 5.3. 입력 문제

- 클래스 명	JAVA , ORACLE
- 이슈 사항	텍스트 데이터를 처리하는 과정에서 문법이 다름으로 인해 문제가 발생
- 원인	문자열처리: 쿼리문 - 홑따옴표, 자바 - 겹따옴표 사용으로 어느쪽을 선택하더라도 다른 한쪽에서 문제가 발생

<details>
<summary><b>해결 단계</b></summary>
- **시도1. 시도한 내용**
    - 텍스트 자바 입력 문제 -> 홑따옴표
    - 텍스트 오라클 입력 문제 -> 따옴표 삭제

</div>
</details>

<details>
<summary><b>해결 방법</b></summary>
쿼리 입력문 내 따옴표를 모두 삭제하여 문제 해결

</div>
</details>

### 5.4. DB 연결오류

- 클래스 명	JAVA - UserDAO
- 이슈 사항	loginVo 초기화 안 됨
- 원인	loginVo가 null로만 선언되어 있고, 성공했을 때도 값이 안 들어감

<details>
<summary><b>해결 단계</b></summary>
시도1. 시도한 내용
if (rs.next()) { 
            loginVo = new Gamer();
            loginVo.setId(rs.getString("ID"));
            loginVo.setPw(rs.getString("PASSWORD"));
            loginVo.setNickname(rs.getString("NICKNAME")); 
        }

</div>
</details>

<details>
<summary><b>해결 방법</b></summary>
조회 결과가 있으면 User 객체 생성 후 값 세팅 후 필요한 컬럼 추가

</div>
</details>

### 5.5. JAVA ORACLE 연결

- 클래스 명	JAVA - UserDAO
- 이슈 사항	ORACLE 연결
- 원인	SQL 입력 구문

<details>
<summary><b>해결 단계</b></summary>
시도1. 시도한 내용
초기 값 설정 없이 원하는 값만 입력
→ 초기 값 설정하기
String sql = "INSERT INTO GAMER (ID, PASSWORD, NICKNAME) VALUES (?, ?, ?)";

</div>
</details>

<details>
<summary><b>해결 방법</b></summary>
SQL 입력 구문 초기 값 설정 후 원하는 값 입력 하기

</div>
</details>

## 6. 회고 / 느낀점
>프로젝트 개발 회고 글: https://zuminternet.github.io/ZUM-Pilot-integer/
