# higg_v2 소개 

소환사명으로 lol 유저 전적 검색, 해당 소환사에게 댓글을 남길 수 있는 higg_v2



# higg_v2 기능 설명

1. restTemplate객체로 riot api와 datadragon 에서 데이터를 받아와 gson 라이브러리를 이용해 전달받은 데이터 처리
2. spring boot jpa를 이용한 데이터베이스 구현 (회원, 댓글), table join 처리 // mysql
4. 검색한 해당 유저 전적 페이지에 댓글 crud 기능 비동기 구현 ajax && axios
3. thymeleaf를 이용한 view 페이지 // 시간이 부족하여 list 페이지만 구현
5. spring boot security를 이용한 회원가입&&로그인 처리, 로그인 한 유저의 role이 ADMIN일 시 모든 댓글 수정, 삭제 가능 / 일반 유저일 시 본인의 댓글만 가능하도록 구현

