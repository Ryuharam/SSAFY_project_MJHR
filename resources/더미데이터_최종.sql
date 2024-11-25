INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('ssafy', 'password_1', '홍길동', 'ssafy@example.com', '도서페이커', 'https://example.com/user_1.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('q1w2e3', 'password_2', '김영희', 'q1w2e3@example.com', '책읽는소녀', 'https://example.com/user_2.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('babyG', 'password_3', '이철수', 'babyG@example.com', '독후감매니아', 'https://example.com/user_3.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('bookworm', 'password_4', '박민수', 'bookworm@example.com', '책사랑꾼', 'https://example.com/user_4.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('reader21', 'password_5', '최지영', 'reader21@example.com', '감성독자', 'https://example.com/user_5.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('devFan', 'password_6', '장미영', 'devFan@example.com', '리뷰천재', 'https://example.com/user_6.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('litLover', 'password_7', '윤정우', 'litLover@example.com', '북스파이', 'https://example.com/user_7.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('javaCoder', 'password_8', '한수민', 'javaCoder@example.com', '책벌레왕', 'https://example.com/user_8.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('springBooter', 'password_9', '송현주', 'springBooter@example.com', '감동리뷰어', 'https://example.com/user_9.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('vueMaster', 'password_10', '정성훈', 'vueMaster@example.com', '마음리뷰', 'https://example.com/user_10.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('fullstack21', 'password_11', '최영준', 'fullstack21@example.com', '책탐구자', 'https://example.com/user_11.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('designPro', 'password_12', '유민지', 'designPro@example.com', '독서의왕', 'https://example.com/user_12.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('kDramaFan', 'password_13', '안지수', 'kDramaFan@example.com', '감성마스터', 'https://example.com/user_13.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('codeLover', 'password_14', '임채연', 'codeLover@example.com', '북헌터', 'https://example.com/user_14.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('jsExpert', 'password_15', '고윤아', 'jsExpert@example.com', '리뷰러버', 'https://example.com/user_15.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('typeScriptFan', 'password_16', '백승민', 'typeScriptFan@example.com', '책조아', 'https://example.com/user_16.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('readerPro', 'password_17', '오정아', 'readerPro@example.com', '열정독자', 'https://example.com/user_17.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('fantasyFan', 'password_18', '이동혁', 'fantasyFan@example.com', '읽기의달인', 'https://example.com/user_18.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('nonFicReader', 'password_19', '강소영', 'nonFicReader@example.com', '리뷰바라기', 'https://example.com/user_19.jpg', 'ACTIVE');

INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img, status)
    VALUES ('libroLover', 'password_20', '문지후', 'libroLover@example.com', '독서광', 'https://example.com/user_20.jpg', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (1, 'codeLover', '9791162241264', '삶의 지혜를 느낄 수 있는 작품입니다.', '구현 순서에 맞춰 프로젝트를 진행하며 배우는 실전 입문서

이 책은 스프링 부트 입문자의 눈높이에 맞춰 스프링 부트 환경 설정부터 커뮤니티 게시판 구현까지를 다룹니다. 스프링 부트의 기본 개념과 다양한 스프링 부트 스타터를 이용해 커뮤니티 게시판 구축 프로젝트를 구현합 이 책은 정말로 깊이 있는 내용을 담고 있습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (2, 'fullstack21', '9791161758558', '새로운 관점을 제시하는 놀라운 책입니다.', '기존 일체형 애플리케이션을 마이크로서비스로 나누고 온프레미스나 클라우드로 배포하려는 자바, 스프링 개발자와 아키텍트를 위한 책이다.
스프링 부트, 스프링 클라우드와 도커, 쿠버네티스, 이스티오, EFK 스택, 프로메테우스, 그라파나 등의 오픈소스 도구를 조합해 마이크로 이 책은 정말로 매우 흥미로웠습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (3, 'fantasyFan', '9791140700448', '감동과 여운이 가득한 책입니다.', '이론은 탄탄하게, 실습은 실무에 가깝게!
스프링 부트와 스프링 클라우드를 이용한 모범 사례를 직접 실행하며 
마이크로서비스의 개념을 확실하게 익히자!

마이크로서비스는 서비스 개발, 그 이상(클라우드, 인프라, 자동화, 테스팅, 회복성, 보안, 인증, 로깅, 모니터링, 이 책은 정말로 추천할만합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (4, 'javaCoder', '9791162242995', '독서의 즐거움을 깨닫게 하는 이야기입니다.', '웹 애플리케이션을 효과적으로 구현하는 실무 비법 대방출

스프링 부트로 웹 개발을 할 때 마주치는 문제를 속 시원하게 해결하고 싶다면 이 책이 답이다. 스프링 부트에서 자주 발생하는 문제의 해결 방법부터 웹플럭스 사용법까지 실무에 꼭 필요한 내용만 담았다. 웹 개발 경 이 책은 정말로 매우 흥미로웠습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (5, 'reader21', '9791192987675', '새로운 관점을 제시하는 놀라운 책입니다.', '클라우드 환경에 스프링 애플리케이션을 구축하는 효과적인 방법

클라우드 기술이 발달하면서 많은 애플리케이션이 클라우드에서 서비스되고 있다. 이 책에서는 가상의 온라인 서점 시스템을 개발하며 클라우드 환경에 애플리케이션을 어떻게 구축하는지 상세히 설명한다. 스프링으로 클 이 책은 정말로 읽을 가치가 충분합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (6, 'babyG', '9791161752556', '독서를 멈출 수 없게 만드는 작품입니다.', '어느새 자바 생태계의 주류 언어로 자리매김한 코틀린 언어를 바탕으로 마이크로서비스와 리액티브에 대해 알아본다. 기본 개념, 작동 원리와 장점을 살펴보는 것을 시작으로 스프링 부트 기반으로 마이크로서비스를 쉽게 만들어보고, 스프링 웹플럭스(WebFlux)를 사용해 넌블로 이 책은 정말로 매우 흥미로웠습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (7, 'bookworm', '9791141012304', '다시 읽고 싶은 감동적인 책입니다.', '이 책은 자바 개발자가 스프링 프레임워크를 이용해서 시스템을 구축하기 위한 스프링 프레임워크 및 부트 프레임워크의 필수 내용을 원리와 함께 실전 코드까지 설명하고 있습니다. 뷰 페이지를 작성하기 위해 스프링 프레임워크 프로젝트에는 JSP를 사용했으며, 스프링 부트 프로 이 책은 정말로 매우 흥미로웠습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (8, 'springBooter', '9791189184117', '독자들에게 큰 교훈을 주는 책입니다.', '리액트와 스프링 부트를 이용해서 프런트 엔드와 백 엔드를 분리한다면?
이 책은 리액트의 문법이나 기능을 다루는 책이 아닙니다. 이 책에서 다루는 주제는 리액트를 어떻게 활용하는가입니다. 리액트는 많은 기능을 제공하지만, 그 자체로 프레임워크는 아니기 때문에 설계의  이 책은 정말로 매우 흥미로웠습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (9, 'codeLover', '9791141076870', '새로운 관점을 제시하는 놀라운 책입니다.', 'Spring framework와 Spring Boot를 이용한 자바 웹 애플리케이션을 개발하려는 개발자가 보는 책입니다.
이 책은 자바프로그래밍 및 Servlet/JSP 웹 애플리케이션에 대한 기초 지식이 있어야 볼 수 있습니다.
스프링 프레임워크와 스프링 부트는 학습 이 책은 정말로 추천할만합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (10, 'designPro', '9791186710456', '다시 읽고 싶은 감동적인 책입니다.', '스프링의 개념 이해부터 클라우드 컴퓨팅까지, 한 번에 잡는 퍼펙트 강의

스프링 프레임워크에 대한 설명을 시작으로 스프링 부트의 등장 배경과 특징을 살펴봅니다. 그리고 게시판 애플리케이션을 완성하는 것을 목표로 REST API 개발 과정을 친절하게 설명합니다. OAut 이 책은 정말로 추천할만합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (11, 'jsExpert', '9791161756776', '감동과 여운이 가득한 책입니다.', '다수의 사용자를 지원하는 Todo 웹 애플리케이션을 구현하고 배포한다. 또한 현장에서 많이 사용하는 프론트엔드와 백엔드 서버가 분리된 아키텍처(Decoupled Architecture)를 구현한다. 또한 배포 시 단순히 로컬 환경이나 임시 HTTP 서버로 배포하는 데  이 책은 정말로 깊이 있는 내용을 담고 있습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (12, 'springBooter', '9791158394097', '감동과 여운이 가득한 책입니다.', '스프링 부트와 리액트의 풍부하고 다양한 도구들을 활용해 최신 풀스택 애플리케이션을 개발하는 비법을 배워보자!

풀스택 개발을 시작하려면 무엇부터 시작할지 혼란스럽게 느껴질 수 있다. 스프링 부트와 리액트 같은 최고의 툴에 익숙한 개발자라도 고급 요소를 마스터하는 것은  이 책은 정말로 깊이 있는 내용을 담고 있습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (13, 'nonFicReader', '9791161758633', '독서를 멈출 수 없게 만드는 작품입니다.', '스프링 부트 3에 대한 포괄적인 가이드로, 초보자부터 숙련된 개발자까지 모든 수준의 독자들이 활용할 수 있도록 구성돼 있다. 복잡한 인프라 설정을 피하고 효율적인 개발 방법에 초점을 맞춰 웹 애플리케이션 개발의 기초부터 고급 주제까지 다룬다. 주요 내용으로는 빠른 애플 이 책은 정말로 읽을 가치가 충분합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (14, 'typeScriptFan', '9791161751108', '감동과 여운이 가득한 책입니다.', '마이크로서비스 아키텍처 개념을 먼저 알아보고 일반적인 스프링 부트 웹 애플리케이션을 스프링 클라우드, 스프링 리액티브 기술을 활용해서 마이크로서비스로 만들어가는 과정을 풍부한 예제와 실행 화면을 통해 구체적으로 보여준다. 마이크로서비스 적용 시 신경 써야 할 로깅과 모 이 책은 정말로 읽을 가치가 충분합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (15, 'fantasyFan', '9791188621279', '독특한 시각과 접근이 돋보입니다.', '자바 기반의 웹 서비스를 가장 쉽고 빠르게 배운다!

시중에는 자바 웹 개발자를 위한 스프링과 JSP 관련 서적이 많이 나와 있긴 하지만, 입문자가 끝까지 따라 할 만한 책은 많지 않습니다. 이 책은 독자들이 자바 기반의 웹 서비스를 만들거나 공부할 때 가장 쉽게 따라 이 책은 정말로 읽을 가치가 충분합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (16, 'readerPro', '9791161752556', '다시 읽고 싶은 감동적인 책입니다.', '어느새 자바 생태계의 주류 언어로 자리매김한 코틀린 언어를 바탕으로 마이크로서비스와 리액티브에 대해 알아본다. 기본 개념, 작동 원리와 장점을 살펴보는 것을 시작으로 스프링 부트 기반으로 마이크로서비스를 쉽게 만들어보고, 스프링 웹플럭스(WebFlux)를 사용해 넌블로 이 책은 정말로 읽을 가치가 충분합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (17, 'jsExpert', '9791162242995', '독특한 시각과 접근이 돋보입니다.', '웹 애플리케이션을 효과적으로 구현하는 실무 비법 대방출

스프링 부트로 웹 개발을 할 때 마주치는 문제를 속 시원하게 해결하고 싶다면 이 책이 답이다. 스프링 부트에서 자주 발생하는 문제의 해결 방법부터 웹플럭스 사용법까지 실무에 꼭 필요한 내용만 담았다. 웹 개발 경 이 책은 정말로 읽을 가치가 충분합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (18, 'fantasyFan', '9791158391850', '다시 읽고 싶은 감동적인 책입니다.', '프런트엔드와 백엔드 웹 개발에서 스프링과 Vue를 사용해 효율성을 높이자!

이 책은 실용적인 접근법으로 풀스택 웹 개발자가 되는 데 도움을 줍니다. 개발자는 프런트엔드와 백엔드 코드를 작성하는 방법을 아는 것은 물론이고, 애플리케이션에 대한 아이디어부터 시작해 UI, 이 책은 정말로 추천할만합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (20, 'jsExpert', '9791161758558', '독자들에게 큰 교훈을 주는 책입니다.', '기존 일체형 애플리케이션을 마이크로서비스로 나누고 온프레미스나 클라우드로 배포하려는 자바, 스프링 개발자와 아키텍트를 위한 책이다.
스프링 부트, 스프링 클라우드와 도커, 쿠버네티스, 이스티오, EFK 스택, 프로메테우스, 그라파나 등의 오픈소스 도구를 조합해 마이크로 이 책은 정말로 매우 흥미로웠습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (21, 'fantasyFan', '9791161754673', '감동과 여운이 가득한 책입니다.', '★ 요약 ★

기존 일체형 애플리케이션을 마이크로서비스로 나누고 온프레미스나 클라우드로 배포하려는 자바, 스프링 개발자와 아키텍트를 위한 책이다. 
스프링 부트, 스프링 클라우드와 도커, 쿠버네티스, 이스티오, EFK 스택, 프로메테우스, 그라파나 등의 오픈 소스 도구 이 책은 정말로 깊이 있는 내용을 담고 있습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (22, 'nonFicReader', '9791161758633', '독특한 시각과 접근이 돋보입니다.', '스프링 부트 3에 대한 포괄적인 가이드로, 초보자부터 숙련된 개발자까지 모든 수준의 독자들이 활용할 수 있도록 구성돼 있다. 복잡한 인프라 설정을 피하고 효율적인 개발 방법에 초점을 맞춰 웹 애플리케이션 개발의 기초부터 고급 주제까지 다룬다. 주요 내용으로는 빠른 애플 이 책은 정말로 매우 흥미로웠습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (23, 'jsExpert', '9791141031527', '흥미롭고 깊이 있는 이야기입니다.', '하루만 투자하면 스프링 부트로 웹 어플리케이션을 만드는 과정을 따라할 수 있습니다.

이 글은 스프링 부트를 이용해 웹을 개발하는 방법을 최대한 간결하게 설명합니다. 
복잡한 이론보다는 툴과 프레임워크 사용법에 촛점을 맞추고 하나씩 따라할 수 있도록 구성했습니다.
간단 이 책은 정말로 추천할만합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (24, 'q1w2e3', '9791195484577', '독특한 시각과 접근이 돋보입니다.', '이 책은 Spring Boot와 Spring Data JPA, Thymeleaf를 이용해서 프로젝트를 사용하는 방법에 대해 설명한다. 대상 독자는 Spring 프레임워크를 어느 정도 학습해본 초급 개발자들을 대상으로 현실적인 개발 가이드를 제공하는 것을 목표로 하고 있 이 책은 정말로 읽을 가치가 충분합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (25, 'springBooter', '9791191905298', '독서를 멈출 수 없게 만드는 작품입니다.', '★ 자바 백엔드 개발자가 되고 싶다면
★ 자바 언어 입문 그다음에 꼭 보세요실력을 갖춘 개발자로 성장하려면 시작이 중요합니다. 그래서 이 책은 무엇부터 익혀야 하는지 막막한 입문자에게 백엔드 개발의 필수 지식을 학습 로드맵 중심으로 설명합니다. 이어서 스프링 부트 3  이 책은 정말로 매우 흥미로웠습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (26, 'litLover', '9791161754673', '마음에 잔잔한 울림을 남깁니다.', '★ 요약 ★

기존 일체형 애플리케이션을 마이크로서비스로 나누고 온프레미스나 클라우드로 배포하려는 자바, 스프링 개발자와 아키텍트를 위한 책이다. 
스프링 부트, 스프링 클라우드와 도커, 쿠버네티스, 이스티오, EFK 스택, 프로메테우스, 그라파나 등의 오픈 소스 도구 이 책은 정말로 매우 흥미로웠습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (27, 'readerPro', '9791161756776', '독서의 즐거움을 깨닫게 하는 이야기입니다.', '다수의 사용자를 지원하는 Todo 웹 애플리케이션을 구현하고 배포한다. 또한 현장에서 많이 사용하는 프론트엔드와 백엔드 서버가 분리된 아키텍처(Decoupled Architecture)를 구현한다. 또한 배포 시 단순히 로컬 환경이나 임시 HTTP 서버로 배포하는 데  이 책은 정말로 읽을 가치가 충분합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (28, 'javaCoder', '9791141031527', '독서의 즐거움을 깨닫게 하는 이야기입니다.', '하루만 투자하면 스프링 부트로 웹 어플리케이션을 만드는 과정을 따라할 수 있습니다.

이 글은 스프링 부트를 이용해 웹을 개발하는 방법을 최대한 간결하게 설명합니다. 
복잡한 이론보다는 툴과 프레임워크 사용법에 촛점을 맞추고 하나씩 따라할 수 있도록 구성했습니다.
간단 이 책은 정말로 깊이 있는 내용을 담고 있습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (29, 'springBooter', '9791140705078', '독서의 즐거움을 깨닫게 하는 이야기입니다.', '스프링 부트 백엔드 개발,
실습 문턱을 낮추고 자신 있게 시작하자!

스프링 부트를 처음 접하는 입문자와 이미 공부했지만 부족하다고 느끼는 분들을 위한 책입니다. 게시판을 만들며 클라이언트와 서버가 데이터를 주고받을 때 적용되는 핵심 개념 3가지, MVC 패턴, JPA 이 책은 정말로 읽을 가치가 충분합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (30, 'typeScriptFan', '9791161758633', '독자들에게 큰 교훈을 주는 책입니다.', '스프링 부트 3에 대한 포괄적인 가이드로, 초보자부터 숙련된 개발자까지 모든 수준의 독자들이 활용할 수 있도록 구성돼 있다. 복잡한 인프라 설정을 피하고 효율적인 개발 방법에 초점을 맞춰 웹 애플리케이션 개발의 기초부터 고급 주제까지 다룬다. 주요 내용으로는 빠른 애플 이 책은 정말로 읽을 가치가 충분합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (31, 'readerPro', '9788968487590', '독서의 즐거움을 깨닫게 하는 이야기입니다.', '생산성 향상을 꿈꾸는 현업 개발자를 위한 스프링 부트 실무 가이드!

스프링 부트는 ‘최소한의 노력으로 스프링 기반 프로젝트를 시작할 수 있는’ 기술이다. 강력한 스프링 기능을 바탕으로 많은 코드 작성 없이도 바로 출시가 가능한 수준의 앱을 간편하게 만들 수 있다. 
 이 책은 정말로 깊이 있는 내용을 담고 있습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (32, 'nonFicReader', '9791161758633', '감동과 여운이 가득한 책입니다.', '스프링 부트 3에 대한 포괄적인 가이드로, 초보자부터 숙련된 개발자까지 모든 수준의 독자들이 활용할 수 있도록 구성돼 있다. 복잡한 인프라 설정을 피하고 효율적인 개발 방법에 초점을 맞춰 웹 애플리케이션 개발의 기초부터 고급 주제까지 다룬다. 주요 내용으로는 빠른 애플 이 책은 정말로 매우 흥미로웠습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (33, 'fullstack21', '9791141031527', '마음에 잔잔한 울림을 남깁니다.', '하루만 투자하면 스프링 부트로 웹 어플리케이션을 만드는 과정을 따라할 수 있습니다.

이 글은 스프링 부트를 이용해 웹을 개발하는 방법을 최대한 간결하게 설명합니다. 
복잡한 이론보다는 툴과 프레임워크 사용법에 촛점을 맞추고 하나씩 따라할 수 있도록 구성했습니다.
간단 이 책은 정말로 읽을 가치가 충분합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (34, 'reader21', '9791161758633', '삶의 지혜를 느낄 수 있는 작품입니다.', '스프링 부트 3에 대한 포괄적인 가이드로, 초보자부터 숙련된 개발자까지 모든 수준의 독자들이 활용할 수 있도록 구성돼 있다. 복잡한 인프라 설정을 피하고 효율적인 개발 방법에 초점을 맞춰 웹 애플리케이션 개발의 기초부터 고급 주제까지 다룬다. 주요 내용으로는 빠른 애플 이 책은 정말로 추천할만합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (35, 'codeLover', '9791192987675', '삶의 지혜를 느낄 수 있는 작품입니다.', '클라우드 환경에 스프링 애플리케이션을 구축하는 효과적인 방법

클라우드 기술이 발달하면서 많은 애플리케이션이 클라우드에서 서비스되고 있다. 이 책에서는 가상의 온라인 서점 시스템을 개발하며 클라우드 환경에 애플리케이션을 어떻게 구축하는지 상세히 설명한다. 스프링으로 클 이 책은 정말로 매우 흥미로웠습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (36, 'fantasyFan', '9791191905298', '마음에 잔잔한 울림을 남깁니다.', '★ 자바 백엔드 개발자가 되고 싶다면
★ 자바 언어 입문 그다음에 꼭 보세요실력을 갖춘 개발자로 성장하려면 시작이 중요합니다. 그래서 이 책은 무엇부터 익혀야 하는지 막막한 입문자에게 백엔드 개발의 필수 지식을 학습 로드맵 중심으로 설명합니다. 이어서 스프링 부트 3  이 책은 정말로 깊이 있는 내용을 담고 있습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (37, 'jsExpert', '9791161756776', '삶의 지혜를 느낄 수 있는 작품입니다.', '다수의 사용자를 지원하는 Todo 웹 애플리케이션을 구현하고 배포한다. 또한 현장에서 많이 사용하는 프론트엔드와 백엔드 서버가 분리된 아키텍처(Decoupled Architecture)를 구현한다. 또한 배포 시 단순히 로컬 환경이나 임시 HTTP 서버로 배포하는 데  이 책은 정말로 추천할만합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (38, 'reader21', '9791192987354', '흥미롭고 깊이 있는 이야기입니다.', '인류에겐 이런 스프링 부트 가이드북이 필요했다

방대한 스프링 부트 공식 문서 중 실무에서 잘 쓰이는 팁을 찾기란 어렵다. 이 책은 초급에서 중급 수준의 독자를 대상으로 스프링 부트의 기본 개념부터 다양한 기능을 효과적으로 사용하는 고급 개념까지 알려주며, 실무에서 겪 이 책은 정말로 매우 흥미로웠습니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (39, 'javaCoder', '9791141097547', '독서의 즐거움을 깨닫게 하는 이야기입니다.', '자바와 파이썬을 연결하는 방법을 응용하여 다양한 AI 서비스 구축 환경에 활용할 수 있습니다.
- 파이썬 FastAPI와 자바 스프링 부트를 이용한 웹 애플리케이션 프로젝트를 설명합니다.
- 자바 웹 애플리케이션과 파이썬 웹 애플리케이션 간의 정보 교환 방법을 설명합니 이 책은 정말로 추천할만합니다.', 'ACTIVE');

INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content, status)
    VALUES (40, 'codeLover', '9791140700448', '삶의 지혜를 느낄 수 있는 작품입니다.', '이론은 탄탄하게, 실습은 실무에 가깝게!
스프링 부트와 스프링 클라우드를 이용한 모범 사례를 직접 실행하며 
마이크로서비스의 개념을 확실하게 익히자!

마이크로서비스는 서비스 개발, 그 이상(클라우드, 인프라, 자동화, 테스팅, 회복성, 보안, 인증, 로깅, 모니터링, 이 책은 정말로 추천할만합니다.', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (1, 'litLover', '9791191905717', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (2, 'fantasyFan', '9791191905717', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (3, 'codeLover', '9791191905717', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (4, 'reader21', '9791191905717', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (5, 'kDramaFan', '9791191905717', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (6, 'designPro', '9791191905717', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (7, 'babyG', '9791191905717', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (8, 'kDramaFan', '9791161758633', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (9, 'q1w2e3', '9791161758633', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (10, 'litLover', '9791161758633', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (11, 'devFan', '9791192987354', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (12, 'typeScriptFan', '9791192987354', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (13, 'designPro', '9791192987354', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (14, 'fullstack21', '9791192987354', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (15, 'libroLover', '9791192987354', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (16, 'codeLover', '9791192987354', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (17, 'litLover', '9791192987354', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (18, 'javaCoder', '9791192987354', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (19, 'javaCoder', '9791161752624', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (20, 'ssafy', '9791161752624', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (21, 'springBooter', '9791161752624', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (22, 'bookworm', '9791161752624', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (23, 'designPro', '9791161752624', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (24, 'vueMaster', '9791161752624', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (25, 'readerPro', '9791161752624', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (26, 'jsExpert', '9791161752624', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (27, 'fantasyFan', '9791161752624', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (28, 'nonFicReader', '9791195484577', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (29, 'codeLover', '9791195484577', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (30, 'typeScriptFan', '9791195484577', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (31, 'vueMaster', '9791195484577', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (32, 'javaCoder', '9791195484577', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (33, 'devFan', '9791195484577', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (34, 'reader21', '9791195484577', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (35, 'vueMaster', '9791186710487', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (36, 'jsExpert', '9791186710487', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (37, 'typeScriptFan', '9791186710487', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (38, 'readerPro', '9791186710487', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (39, 'kDramaFan', '9791186710487', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (40, 'litLover', '9791186710487', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (41, 'javaCoder', '9791186710487', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (42, 'libroLover', '9791186710487', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (43, 'springBooter', '9791186710487', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (44, 'bookworm', '9788966262304', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (45, 'nonFicReader', '9788966262304', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (46, 'springBooter', '9788966262304', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (47, 'ssafy', '9788966262304', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (48, 'q1w2e3', '9791161753478', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (49, 'devFan', '9791161753478', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (50, 'typeScriptFan', '9791161753478', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (51, 'designPro', '9791161753478', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (52, 'jsExpert', '9791187497158', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (53, 'springBooter', '9791187497158', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (54, 'fantasyFan', '9791187497158', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (55, 'ssafy', '9791187497158', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (56, 'devFan', '9791187497158', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (57, 'reader21', '9791187497158', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (58, 'vueMaster', '9791187497158', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (59, 'babyG', '9791187497158', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (60, 'springBooter', '9791161758305', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (61, 'litLover', '9791161758305', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (62, 'ssafy', '9791161758305', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (63, 'nonFicReader', '9791161758305', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (64, 'bookworm', '9791158393083', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (65, 'devFan', '9791158393083', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (66, 'readerPro', '9791158393083', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (67, 'nonFicReader', '9791158393083', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (68, 'fullstack21', '9791158393083', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (69, 'typeScriptFan', '9791158393083', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (70, 'vueMaster', '9788968487590', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (71, 'javaCoder', '9788968487590', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (72, 'fantasyFan', '9788968487590', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (73, 'ssafy', '9788968487590', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (74, 'reader21', '9788968487590', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (75, 'jsExpert', '9788968487590', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (76, 'nonFicReader', '9788968487590', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (77, 'springBooter', '9788968487590', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (78, 'codeLover', '9791187345534', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (79, 'litLover', '9791187345534', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (80, 'typeScriptFan', '9791187345534', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (81, 'vueMaster', '9791187345534', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (82, 'fantasyFan', '9791187345534', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (83, 'libroLover', '9791187345534', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (84, 'devFan', '9791187345534', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (85, 'vueMaster', '9791163035398', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (86, 'ssafy', '9791163035398', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (87, 'designPro', '9791163035398', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (88, 'litLover', '9791163035398', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (89, 'javaCoder', '9791163035398', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (90, 'litLover', '9791162241264', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (91, 'libroLover', '9791162241264', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (92, 'jsExpert', '9791162241264', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (93, 'javaCoder', '9791162241264', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (94, 'ssafy', '9791162241264', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (95, 'bookworm', '9791162241264', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (96, 'codeLover', '9791162241264', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (97, 'reader21', '9791162241264', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (98, 'ssafy', '9791141031527', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (99, 'babyG', '9791186710456', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (100, 'javaCoder', '9791186710456', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (101, 'vueMaster', '9791186710456', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (102, 'typeScriptFan', '9791186710456', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (103, 'designPro', '9791186710456', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (104, 'libroLover', '9791189909307', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (105, 'fullstack21', '9791160501506', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (106, 'kDramaFan', '9791160501506', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (107, 'ssafy', '9791160501506', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (108, 'typeScriptFan', '9791160501506', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (109, 'nonFicReader', '9791160501506', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (110, 'fantasyFan', '9791160501506', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (111, 'litLover', '9791165920302', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (112, 'vueMaster', '9791165920302', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (113, 'q1w2e3', '9791165920302', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (114, 'fullstack21', '9791162242995', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (115, 'vueMaster', '9791162242995', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (116, 'codeLover', '9791162242995', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (117, 'fantasyFan', '9791162242995', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (118, 'typeScriptFan', '9791188621279', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (119, 'javaCoder', '9791188621279', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (120, 'babyG', '9791188621279', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (121, 'reader21', '9791188621279', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (122, 'libroLover', '9791188621279', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (123, 'litLover', '9791188621279', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (124, 'q1w2e3', '9791188621279', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (125, 'designPro', '9791188621279', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (126, 'reader21', '9791169210966', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (127, 'jsExpert', '9791169210966', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (128, 'devFan', '9791169210966', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (129, 'q1w2e3', '9791169210966', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (130, 'springBooter', '9791169210966', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (131, 'javaCoder', '9791169210966', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (132, 'readerPro', '9791169210966', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (133, 'typeScriptFan', '9791169210966', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (134, 'designPro', '9791169210966', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (135, 'litLover', '9791169210966', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (136, 'q1w2e3', '9791189184124', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (137, 'javaCoder', '9791189184124', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (138, 'ssafy', '9791189184124', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (139, 'fantasyFan', '9791161757629', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (140, 'javaCoder', '9791161757629', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (141, 'jsExpert', '9791161757629', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (142, 'nonFicReader', '9791191905298', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (143, 'litLover', '9791191905298', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (144, 'codeLover', '9791191905298', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (145, 'reader21', '9791191905298', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (146, 'designPro', '9791191905298', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (147, 'jsExpert', '9791189184070', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (148, 'devFan', '9791189184070', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (149, 'readerPro', '9791189184070', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (150, 'typeScriptFan', '9791189184070', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (151, 'codeLover', '9791189184117', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (152, 'q1w2e3', '9791189184117', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (153, 'devFan', '9791189184117', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (154, 'kDramaFan', '9791140702121', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (155, 'springBooter', '9791140702121', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (156, 'fantasyFan', '9791140702121', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (157, 'codeLover', '9791140702121', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (158, 'javaCoder', '9791140702121', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (159, 'devFan', '9791140702121', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (160, 'nonFicReader', '9791140702121', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (161, 'reader21', '9791140702121', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (162, 'reader21', '9791141097547', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (163, 'ssafy', '9791141097547', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (164, 'devFan', '9791161750286', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (165, 'kDramaFan', '9791161750286', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (166, 'typeScriptFan', '9791161750286', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (167, 'ssafy', '9791161750286', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (168, 'jsExpert', '9791161750286', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (169, 'bookworm', '9788924100174', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (170, 'typeScriptFan', '9791158391416', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (171, 'babyG', '9791158391416', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (172, 'codeLover', '9791158391416', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (173, 'nonFicReader', '9791158391416', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (174, 'designPro', '9791158391416', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (175, 'libroLover', '9791158391416', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (176, 'jsExpert', '9791158391416', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (177, 'q1w2e3', '9791158391416', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (178, 'kDramaFan', '9791158391416', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (179, 'kDramaFan', '9791192987675', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (180, 'fullstack21', '9791192987675', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (181, 'designPro', '9791192987675', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (182, 'springBooter', '9791192987675', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (183, 'libroLover', '9791192987675', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (184, 'fantasyFan', '9791192987675', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (185, 'javaCoder', '9791192987675', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (186, 'devFan', '9791192987675', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (187, 'babyG', '9791192987675', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (188, 'javaCoder', '9791140705078', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (189, 'jsExpert', '9788965402602', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (190, 'designPro', '9788965402602', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (191, 'javaCoder', '9788965402602', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (192, 'fantasyFan', '9788965402602', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (193, 'jsExpert', '9791141076870', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (194, 'ssafy', '9791141076870', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (195, 'libroLover', '9791141012304', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (196, 'nonFicReader', '9791141012304', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (197, 'babyG', '9791141012304', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (198, 'q1w2e3', '9791141012304', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (199, 'codeLover', '9791141012304', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (200, 'springBooter', '9791141012304', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (201, 'bookworm', '9791141012304', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (202, 'springBooter', '9791161751108', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (203, 'q1w2e3', '9791161751108', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (204, 'typeScriptFan', '9791161751108', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (205, 'designPro', '9791161751108', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (206, 'ssafy', '9791161751108', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (207, 'fullstack21', '9791161751108', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (208, 'libroLover', '9791161751108', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (209, 'vueMaster', '9791161751108', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (210, 'designPro', '9791161756776', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (211, 'codeLover', '9791161756776', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (212, 'libroLover', '9791161756776', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (213, 'springBooter', '9791161756776', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (214, 'devFan', '9791161756776', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (215, 'jsExpert', '9791161756776', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (216, 'readerPro', '9791161756776', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (217, 'q1w2e3', '9791161756776', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (218, 'nonFicReader', '9791161756776', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (219, 'nonFicReader', '9791161758558', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (220, 'devFan', '9791161758558', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (221, 'jsExpert', '9791161758558', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (222, 'kDramaFan', '9788997924899', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (223, 'libroLover', '9788997924899', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (224, 'codeLover', '9788997924899', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (225, 'vueMaster', '9788997924899', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (226, 'babyG', '9788997924899', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (227, 'reader21', '9791161755656', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (228, 'readerPro', '9791161755656', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (229, 'devFan', '9791158394097', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (230, 'babyG', '9791158394097', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (231, 'javaCoder', '9791158394097', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (232, 'libroLover', '9791158394097', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (233, 'q1w2e3', '9791158394097', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (234, 'reader21', '9791158394097', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (235, 'jsExpert', '9791158394097', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (236, 'jsExpert', '9791140700448', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (237, 'fantasyFan', '9791140700448', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (238, 'fullstack21', '9791140700448', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (239, 'javaCoder', '9791140700448', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (240, 'vueMaster', '9791140700448', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (241, 'designPro', '9791140700448', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (242, 'designPro', '9791161754406', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (243, 'reader21', '9791161754406', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (244, 'litLover', '9791161754406', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (245, 'typeScriptFan', '9791161754406', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (246, 'kDramaFan', '9791161754406', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (247, 'nonFicReader', '9791161751825', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (248, 'reader21', '9791161751825', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (249, 'springBooter', '9791161751825', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (250, 'devFan', '9791161751825', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (251, 'kDramaFan', '9791161751825', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (252, 'fantasyFan', '9791161751825', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (253, 'jsExpert', '9791161751825', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (254, 'nonFicReader', '9791161754673', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (255, 'q1w2e3', '9791161754673', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (256, 'javaCoder', '9791161754673', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (257, 'vueMaster', '9791161754673', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (258, 'babyG', '9791161754673', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (259, 'fullstack21', '9791161754673', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (260, 'devFan', '9791161754673', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (261, 'springBooter', '9791161754673', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (262, 'designPro', '9791158391850', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (263, 'typeScriptFan', '9791158391850', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (264, 'kDramaFan', '9791158391850', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (265, 'bookworm', '9791158391850', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (266, 'jsExpert', '9791161752556', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (267, 'litLover', '9791161752556', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (268, 'bookworm', '9791161752556', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (269, 'babyG', '9791161752556', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (270, 'vueMaster', '9791161752556', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (271, 'typeScriptFan', '9791161752556', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (272, 'q1w2e3', '9791161752556', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (273, 'reader21', '9791161752556', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (274, 'codeLover', '9791188621415', 'ACTIVE');

INSERT INTO book_like (book_like_id, user_id, isbn, status)
    VALUES (275, 'libroLover', '9791188621415', 'ACTIVE');