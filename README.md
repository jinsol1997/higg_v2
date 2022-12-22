# higg_v2 소개 

소환사명으로 lol 유저 전적 검색, 해당 소환사에게 댓글을 남길 수 있는 higg_v2



# higg_v2 기능 설명

1. restTemplate객체로 riot api와 datadragon 에서 데이터를 받아와 gson 라이브러리를 이용해 전달받은 데이터 처리
2. spring boot jpa를 이용한 데이터베이스 구현 (회원, 댓글), table join 처리 // mysql
4. 검색한 해당 유저 전적 페이지에 댓글 crud 기능 비동기 구현 ajax && axios
3. thymeleaf를 이용한 view 페이지 // 시간이 부족하여 list 페이지만 구현
5. spring boot security를 이용한 회원가입&&로그인 처리, 로그인 한 유저의 role이 ADMIN일 시 모든 댓글 수정, 삭제 가능 / 일반 유저일 시 본인의 댓글만 가능하도록 구현


# DB DDL

CREATE TABLE `higg_member` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `uid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pw` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idx`),
  UNIQUE KEY `uid_UNIQUE` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin

CREATE TABLE `higg_comment` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `writer` int NOT NULL,
  `puuid` varchar(100) COLLATE utf8mb3_bin NOT NULL,
  `reply` varchar(100) COLLATE utf8mb3_bin NOT NULL,
  `replydate` date NOT NULL,
  `updatedate` date DEFAULT NULL,
  PRIMARY KEY (`idx`),
  KEY `writer_idx` (`writer`),
  CONSTRAINT `writer` FOREIGN KEY (`writer`) REFERENCES `higg_member` (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin



# DB ERD

![higg_v2_erd](https://user-images.githubusercontent.com/113006954/209058525-eb59b1a7-ccf0-4371-8333-e8c83cba59dc.PNG)



# higg_v2 

![higg_v2](https://user-images.githubusercontent.com/113006954/209055977-c1765f30-b767-48c3-a56c-cbd0d5f249fa.PNG)
