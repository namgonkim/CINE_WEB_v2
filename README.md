# CINE_Web_v2
연구실 CINE Lab 홈페이지 version 2 
 - 스프링 부트를 사용해 기존 시스템 개선 및 재 구축
 
 ### 기술
 - Spring boot 2.3.7
 - Spring JPA
 - Spring Security
 - Mysql 8.0.x
 - JSP
 
 ### Want to
 - JSP를 React로
 - MSA활용
 - 데이터 저장 클라우드에


### To do (개선해야할 사항)
 - 스프링 시큐리티를 사용하여 관리자 세팅을 진행 중
 > ajax 비동기 로그인 사용 시 비정상 작동
 > 쿠키? 세션? 이 완전하게 지워지지 않는 것 같음. 처음 로그인 성공 시 json타입 매핑 페이지로 넘어감. 로그아웃 후 다시 로그인하면 정상 작동.
 
 - 리서치, 퍼블리케이션, 뉴스 CRUD 구현할 것. (~2021-01-26)
 
 - Lecture 제외하고 다른 page CRUD 구현 완료. (~2012-01-27)
 > 미세한 예외처리 찾으면 즉시 수정할 것.
 
 - 이미지 업로드 처리
 > 우선 People에 적용했고 팀원 삭제시 이미지 로컬 저장 및 DB까지 연동되서 삭제되도록 해놨음 <br/>
 > BUT MD5제너레이터로 같은 파일명들을 변경할 경우 똑같은 파일 이름으로 생성이됨. 이부분 해결해야 할듯.
