# bbs_demo

# Intro
2022 가온누리 JAVA 서버 스터디 실습 프로젝트
Spring Boot 를 활용한 전자 게시판 실습

# 요구사항 분석
- 사용자는 등록 된 이메일을 활용하여 글을 처리할 수 있어야 한다. 
- 사용자는 등록 된 글을 삭제 및 수정 할 수 있어야 한다. 
- 사용자는 등록 된 글에 댓글을 등록 할 수 있어야 한다.
- 사용자는 등록 된 글의 댓글을 조회 할 수 있어야 한다. 
- 사용자는 등록 된 글의 댓글을 수정 및 삭제 할 수 있어야 한다. 
- 사용자는 등록 된 글을 조건에 맞게 검색 할 수 있어야 한다.
- 사용자는 등록 된 글을 한 페이지 당 10개 씩 볼 수 있어야 한다. 

# API 규격서

|URL|METHOD|파라미터|설명|
|---|------|----|----|
|/board/list|GET|pageRequest (page, size, type, keyword)|파라미터 값에 맞는 페이지의 게시물 데이터 출력|
|/board/register|GET| X |화면 등록 페이지 출력|
|/board/register|POST|BoardDTO|입력 받은 데이터를 기반으로 한 게시글 생성|
|/board/read|GET|pageRequest, bno(board number)|파라미터 값에 맞는 게시글 출력|
|/board/modify|GET|pageRequest, bno(board number)|게시글 수정 페이지 출력|
|/board/modify|POST|BoardDTO, PageRequestDTO|입력받은 데이터를 기반으로 기존 게시글 수정|
|/board/remove|POST|bno(board number)|입력받은 게시글 번호에 해당하는 게시글 삭제|
|/replies/board/{bno}|GET|bno(board number)|해당 게시글의 댓글 목록을 가져옴|
|/replies/{rno}|PUT|rno(reply number)|해당 댓글번호에 할당 된 댓글 수정|
|/replies/{rno}|DELETE|rno(reply number)|해당 댓글번호에 할당 된 댓글 삭제|
|/replies/|POST|ReplyDTO|입력 받은 데이터를 기반으로 새 댓글 등록|



# 엔티티 관계도
<img width="227" alt="image" src="https://user-images.githubusercontent.com/36991763/182017654-d152241b-ea03-46e0-9acf-23a9bfa35115.png">  
member 와 board 사이엔 일대다 관계 (board의 외래키는 writer_email <-> member의 email)  
board와 reply 사이엔 일대다 관계 (reply의 외래키는 board_bno <-> board의 bno)  

# 개발 과정
## Git model
- Master
  - 최종 릴리즈 브랜치
- Dev
  - 개발기 테스트 브랜치
  - 기능 구현 브랜치에서 작업 완료 시 Dev 브랜치에서 테스트
  - 테스트 완료 시 Master 브랜치에 Pull Request
- Feature
  - 기능 구현 브랜치
### Source Tree 캡쳐 이미지
<img width="430" alt="image" src="https://user-images.githubusercontent.com/36991763/182017791-21ebea6d-002e-4e7a-8deb-3593017ad084.png">

# 구현 기능
## 1. 메인 화면
<img width="806" alt="image" src="https://user-images.githubusercontent.com/36991763/182017907-cb879983-7ae8-423e-87e2-f9beeaf0539e.png">

## 2. 게시판 글 조회 기능
<img width="950" alt="image" src="https://user-images.githubusercontent.com/36991763/182017917-5ff8ef16-5acf-46ba-ab83-1b8383338c41.png">

## 3. 게시판 글 등록 기능
<img width="604" alt="image" src="https://user-images.githubusercontent.com/36991763/182018047-d9f92411-91d7-42e9-ab38-295db624ab03.png">

<img width="760" alt="image" src="https://user-images.githubusercontent.com/36991763/182018055-542d0a8c-36a8-4d3d-8a5c-e86ed83a6099.png">

## 4. 게시판 글 수정 및 삭제 기능
<img width="947" alt="image" src="https://user-images.githubusercontent.com/36991763/182017938-31422ad5-03bb-41ba-8390-4e4ae3173cad.png">

## 5. 게시판 페이징 처리
<img width="790" alt="image" src="https://user-images.githubusercontent.com/36991763/182017943-66086388-bf13-48cf-a3a8-2a68a74dd202.png">

## 6. 게시판 글 검색 기능
<img width="955" alt="image" src="https://user-images.githubusercontent.com/36991763/182017948-a455e639-f9aa-42b1-a0fa-b3456a214430.png">

## 7. 게시판 글 댓글 확인 기능
<img width="515" alt="image" src="https://user-images.githubusercontent.com/36991763/182018026-c927bd96-7fe2-465e-b89f-4379ef7aa94b.png">

## 8. 게시판 글 댓글 등록 기능
<img width="551" alt="image" src="https://user-images.githubusercontent.com/36991763/182017980-7e571c89-4d7d-4d9e-b5af-3751fd37277c.png">

<img width="488" alt="image" src="https://user-images.githubusercontent.com/36991763/182017988-4f5adcfe-6f4b-40b0-a950-65bdb0d016d3.png">

## 9. 게시판 글 댓글 수정 및 삭제 기능
<img width="437" alt="image" src="https://user-images.githubusercontent.com/36991763/182018001-f2a9ca78-92ab-49e0-a10c-14c8468dd149.png">

<img width="386" alt="image" src="https://user-images.githubusercontent.com/36991763/182018008-9090abab-9d11-45ab-b807-11b826f25aff.png">

<img width="346" alt="image" src="https://user-images.githubusercontent.com/36991763/182018011-12dfbdd5-f4e7-42c6-aa1a-309c22342b74.png">

<img width="436" alt="image" src="https://user-images.githubusercontent.com/36991763/182018016-4ae85a10-d49e-49ee-a289-348741a1e1b5.png">

# 기술 스택
- Spring Boot
  - JPA
  - QueryDSL
  - JPQL
  - Thymeleaf
- DBMS
  - MariaDB
  - DBeaver

# Reverence
- 코드로 배우는 스프링 부트 웹 프로젝트
  - 개선 사항
    - 디자인 개선
    - Git model 도입을 통한 체계적인 개발 과정 도입
    - TDD 기반의 테스트
  - 추후 개선사항
    - View만 따로 React 로 개발 해 볼 예정
    - 에러 페이지 추가
    - 회원 가입 및 로그인 기능 추가
