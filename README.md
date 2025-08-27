# 나는야 플러팅 마스터❤
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
( 이미지 )

### 3) 피드백 채택 의견 
" 호감도에 따른 대화 등 텍스트양이 걱정됩니다. "
--> 데이터 타입 (VARCHAR2(4000 BYTE)) 수정 후 텍스트 양 조절

" 좀더 구체적으로 게임절차가 짜여줬으면 한다. "
--> 시나리오 구성 & 선택지 작성 후 연결된 결과에 따라 다른 내용 구성

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

## 6. 그 외 트러블 슈팅
<details>
<summary>npm run dev 실행 오류</summary>
<div markdown="1">

- Webpack-dev-server 버전을 3.0.0으로 다운그레이드로 해결
- `$ npm install —save-dev webpack-dev-server@3.0.0`

</div>
</details>

<details>
<summary>vue-devtools 크롬익스텐션 인식 오류 문제</summary>
<div markdown="1">
  
  - main.js 파일에 `Vue.config.devtools = true` 추가로 해결
  - [https://github.com/vuejs/vue-devtools/issues/190](https://github.com/vuejs/vue-devtools/issues/190)
  
</div>
</details>

<details>
<summary>ElementUI input 박스에서 `v-on:keyup.enter="메소드명"`이 정상 작동 안하는 문제</summary>
<div markdown="1">
  
  - `v-on:keyup.enter.native=""` 와 같이 .native 추가로 해결
  
</div>
</details>

<details>
<summary> Post 목록 출력시에 Member 객체 출력 에러 </summary>
<div markdown="1">
  
  - 에러 메세지(500에러)
    - No serializer found for class org.hibernate.proxy.pojo.javassist.JavassistLazyInitializer and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationConfig.SerializationFeature.FAIL_ON_EMPTY_BEANS)
  - 해결
    - Post 엔티티에 @ManyToOne 연관관계 매핑을 LAZY 옵션에서 기본(EAGER)옵션으로 수정
  
</div>
</details>
    
<details>
<summary> 프로젝트를 git init으로 생성 후 발생하는 npm run dev/build 오류 문제 </summary>
<div markdown="1">
  
  ```jsx
    $ npm run dev
    npm ERR! path C:\Users\integer\IdeaProjects\pilot\package.json
    npm ERR! code ENOENT
    npm ERR! errno -4058
    npm ERR! syscall open
    npm ERR! enoent ENOENT: no such file or directory, open 'C:\Users\integer\IdeaProjects\pilot\package.json'
    npm ERR! enoent This is related to npm not being able to find a file.
    npm ERR! enoent

    npm ERR! A complete log of this run can be found in:
    npm ERR!     C:\Users\integer\AppData\Roaming\npm-cache\_logs\2019-02-25T01_23_19_131Z-debug.log
  ```
  
  - 단순히 npm run dev/build 명령을 입력한 경로가 문제였다.
   
</div>
</details>    

<details>
<summary> 태그 선택후 등록하기 누를 때 `object references an unsaved transient instance - save the transient instance before flushing` 오류</summary>
<div markdown="1">
  
  - Post 엔티티의 @ManyToMany에 영속성 전이(cascade=CascadeType.ALL) 추가
    - JPA에서 Entity를 저장할 때 연관된 모든 Entity는 영속상태여야 한다.
    - CascadeType.PERSIST 옵션으로 부모와 자식 Enitity를 한 번에 영속화할 수 있다.
    - 참고
        - [https://stackoverflow.com/questions/2302802/object-references-an-unsaved-transient-instance-save-the-transient-instance-be/10680218](https://stackoverflow.com/questions/2302802/object-references-an-unsaved-transient-instance-save-the-transient-instance-be/10680218)
   
</div>
</details>    

<details>
<summary> JSON: Infinite recursion (StackOverflowError)</summary>
<div markdown="1">
  
  - @JsonIgnoreProperties 사용으로 해결
    - 참고
        - [http://springquay.blogspot.com/2016/01/new-approach-to-solve-json-recursive.html](http://springquay.blogspot.com/2016/01/new-approach-to-solve-json-recursive.html)
        - [https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue](https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue)
        
</div>
</details>  
    
<details>
<summary> H2 접속문제</summary>
<div markdown="1">
  
  - H2의 JDBC URL이 jdbc:h2:~/test 으로 되어있으면 jdbc:h2:mem:testdb 으로 변경해서 접속해야 한다.
        
</div>
</details> 
    
<details>
<summary> 컨텐츠수정 모달창에서 태그 셀렉트박스 드랍다운이 뒤쪽에 보이는 문제</summary>
<div markdown="1">
  
   - ElementUI의 Global Config에 옵션 추가하면 해결
     - main.js 파일에 `Vue.us(ElementUI, { zIndex: 9999 });` 옵션 추가(9999 이하면 안됌)
   - 참고
     - [https://element.eleme.io/#/en-US/component/quickstart#global-config](https://element.eleme.io/#/en-US/component/quickstart#global-config)
        
</div>
</details> 

<details>
<summary> HTTP delete Request시 개발자도구의 XHR(XMLHttpRequest )에서 delete요청이 2번씩 찍히는 이유</summary>
<div markdown="1">
  
  - When you try to send a XMLHttpRequest to a different domain than the page is hosted, you are violating the same-origin policy. However, this situation became somewhat common, many technics are introduced. CORS is one of them.

        In short, server that you are sending the DELETE request allows cross domain requests. In the process, there should be a **preflight** call and that is the **HTTP OPTION** call.

        So, you are having two responses for the **OPTION** and **DELETE** call.

        see [MDN page for CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS).

    - 출처 : [https://stackoverflow.com/questions/35808655/why-do-i-get-back-2-responses-of-200-and-204-when-using-an-ajax-call-to-delete-o](https://stackoverflow.com/questions/35808655/why-do-i-get-back-2-responses-of-200-and-204-when-using-an-ajax-call-to-delete-o)
        
</div>
</details> 

<details>
<summary> 이미지 파싱 시 og:image 경로가 달라서 제대로 파싱이 안되는 경우</summary>
<div markdown="1">
  
  - UserAgent 설정으로 해결
        - [https://www.javacodeexamples.com/jsoup-set-user-agent-example/760](https://www.javacodeexamples.com/jsoup-set-user-agent-example/760)
        - [http://www.useragentstring.com/](http://www.useragentstring.com/)
        
</div>
</details> 
    
<details>
<summary> 구글 로그인으로 로그인한 사용자의 정보를 가져오는 방법이 스프링 2.0대 버전에서 달라진 것</summary>
<div markdown="1">
  
  - 1.5대 버전에서는 Controller의 인자로 Principal을 넘기면 principal.getName(0에서 바로 꺼내서 쓸 수 있었는데, 2.0대 버전에서는 principal.getName()의 경우 principal 객체.toString()을 반환한다.
    - 1.5대 버전에서 principal을 사용하는 경우
    - 아래와 같이 사용했다면,

    ```jsx
    @RequestMapping("/sso/user")
    @SuppressWarnings("unchecked")
    public Map<String, String> user(Principal principal) {
        if (principal != null) {
            OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
            Authentication authentication = oAuth2Authentication.getUserAuthentication();
            Map<String, String> details = new LinkedHashMap<>();
            details = (Map<String, String>) authentication.getDetails();
            logger.info("details = " + details);  // id, email, name, link etc.
            Map<String, String> map = new LinkedHashMap<>();
            map.put("email", details.get("email"));
            return map;
        }
        return null;
    }
    ```

    - 2.0대 버전에서는
    - 아래와 같이 principal 객체의 내용을 꺼내 쓸 수 있다.

    ```jsx
    UsernamePasswordAuthenticationToken token =
                    (UsernamePasswordAuthenticationToken) SecurityContextHolder
                            .getContext().getAuthentication();
            Map<String, Object> map = (Map<String, Object>) token.getPrincipal();

            String email = String.valueOf(map.get("email"));
            post.setMember(memberRepository.findByEmail(email));
    ```
        
</div>
</details> 
    
<details>
<summary> 랭킹 동점자 처리 문제</summary>
<div markdown="1">
  
  - PageRequest의 Sort부분에서 properties를 "rankPoint"를 주고 "likeCnt"를 줘서 댓글수보다 좋아요수가 우선순위 갖도록 설정.
  - 좋아요 수도 똑같다면..........
        
</div>
</details> 
    
</br>

## 6. 회고 / 느낀점
>프로젝트 개발 회고 글: https://zuminternet.github.io/ZUM-Pilot-integer/
