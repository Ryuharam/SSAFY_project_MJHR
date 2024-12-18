use mjhr_db;

SELECT COUNT(1) FROM books;

SET SQL_SAFE_UPDATES = 0;
UPDATE books SET pubdate = STR_TO_DATE(pubdate, '%Y%m%d') WHERE LENGTH(pubdate) = 8;
SET SQL_SAFE_UPDATES = 1; -- 작업 후 다시 활성화

SELECT * FROM books WHERE title = "잘자요";

SHOW VARIABLES LIKE 'character_set%';

-----------------------------------------------------------------------
-- 테이블 데이터만 지우기
-- 외래키 제약조건 비활성화
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE book_like;
TRUNCATE TABLE review_like;
TRUNCATE TABLE review_comments;
TRUNCATE TABLE reviews;
TRUNCATE TABLE books;
TRUNCATE TABLE users;

-- 외래키 제약조건 다시 활성화
SET FOREIGN_KEY_CHECKS = 1;
-----------------------------------------------------------------------
-- 테이블 없애기
DROP TABLE book_like;
DROP TABLE review_like;
DROP TABLE review_comments;
DROP TABLE reviews;
DROP TABLE books;
DROP TABLE users;

-----------------------------------------------------------------------
-- 데이터 확인
SELECT * FROM users;
SELECT * FROM reviews;
SELECT * FROM books;
SELECT * FROM book_like;
SELECT * FROM review_like;
SELECT * FROM review_comments;