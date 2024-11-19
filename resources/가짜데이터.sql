use mjhr_db;

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

-- user 데이터
INSERT INTO users (user_id, user_pw, user_name, user_email, user_nic, user_img) VALUES
('ssafy','1234','김싸피','ssafy@ssafy.com','싸피생',''),
('user_1', 'abc123password', 'User 1', 'user1@example.com', 'nickname_1', 'https://example.com/user_img_1.png'),
('user_2', 'abc456password', 'User 2', 'user2@example.com', 'nickname_2', 'https://example.com/user_img_2.png'),
('user_3', 'abc789password', 'User 3', 'user3@example.com', 'nickname_3', 'https://example.com/user_img_3.png'),
('user_4', 'xyz123password', 'User 4', 'user4@example.com', 'nickname_4', 'https://example.com/user_img_4.png'),
('user_5', 'xyz456password', 'User 5', 'user5@example.com', 'nickname_5', 'https://example.com/user_img_5.png'),
('user_6', 'xyz789password', 'User 6', 'user6@example.com', 'nickname_6', 'https://example.com/user_img_6.png'),
('user_7', 'mno123password', 'User 7', 'user7@example.com', 'nickname_7', 'https://example.com/user_img_7.png'),
('user_8', 'mno456password', 'User 8', 'user8@example.com', 'nickname_8', 'https://example.com/user_img_8.png'),
('user_9', 'mno789password', 'User 9', 'user9@example.com', 'nickname_9', 'https://example.com/user_img_9.png'),
('user_10', 'pqr123password', 'User 10', 'user10@example.com', 'nickname_10', 'https://example.com/user_img_10.png');

-- books 데이터
INSERT INTO books (isbn, title, author, publisher, book_img, publication_date) VALUES
('978-3-16-148410-0', 'Book Title 1', 'Author 1', 'Publisher 1', 'https://example.com/book_img_1.png', '2021-01-01'),
('978-3-16-148411-0', 'Book Title 2', 'Author 2', 'Publisher 2', 'https://example.com/book_img_2.png', '2022-02-02'),
('978-3-16-148412-0', 'Book Title 3', 'Author 3', 'Publisher 3', 'https://example.com/book_img_3.png', '2020-03-03'),
('978-3-16-148413-0', 'Book Title 4', 'Author 4', 'Publisher 4', 'https://example.com/book_img_4.png', '2019-04-04'),
('978-3-16-148414-0', 'Book Title 5', 'Author 5', 'Publisher 5', 'https://example.com/book_img_5.png', '2023-05-05'),
('978-3-16-148415-0', 'Book Title 6', 'Author 6', 'Publisher 6', 'https://example.com/book_img_6.png', '2021-06-06'),
('978-3-16-148416-0', 'Book Title 7', 'Author 7', 'Publisher 7', 'https://example.com/book_img_7.png', '2022-07-07'),
('978-3-16-148417-0', 'Book Title 8', 'Author 8', 'Publisher 8', 'https://example.com/book_img_8.png', '2020-08-08'),
('978-3-16-148418-0', 'Book Title 9', 'Author 9', 'Publisher 9', 'https://example.com/book_img_9.png', '2018-09-09'),
('978-3-16-148419-0', 'Book Title 10', 'Author 10', 'Publisher 10', 'https://example.com/book_img_10.png', '2023-10-10');

-- reviews 데이터
INSERT INTO reviews (review_id, user_id, isbn, review_title, review_content) VALUES
(1, 'user_1', '978-3-16-148410-0', 'Review Title 1', 'This is the content of review 1.'),
(2, 'user_2', '978-3-16-148411-0', 'Review Title 2', 'This is the content of review 2.'),
(3, 'user_3', '978-3-16-148412-0', 'Review Title 3', 'This is the content of review 3.'),
(4, 'user_4', '978-3-16-148413-0', 'Review Title 4', 'This is the content of review 4.'),
(5, 'user_5', '978-3-16-148414-0', 'Review Title 5', 'This is the content of review 5.'),
(6, 'user_6', '978-3-16-148415-0', 'Review Title 6', 'This is the content of review 6.'),
(7, 'user_7', '978-3-16-148416-0', 'Review Title 7', 'This is the content of review 7.'),
(8, 'user_8', '978-3-16-148417-0', 'Review Title 8', 'This is the content of review 8.'),
(9, 'user_9', '978-3-16-148418-0', 'Review Title 9', 'This is the content of review 9.'),
(10, 'user_10', '978-3-16-148419-0', 'Review Title 10', 'This is the content of review 10.');

-- book_like 데이터
INSERT INTO book_like (book_like_id, user_id, isbn) VALUES
(1, 'user_1', '978-3-16-148410-0'),
(2, 'user_2', '978-3-16-148411-0'),
(3, 'user_3', '978-3-16-148412-0'),
(4, 'user_4', '978-3-16-148413-0'),
(5, 'user_5', '978-3-16-148414-0'),
(6, 'user_6', '978-3-16-148415-0'),
(7, 'user_7', '978-3-16-148416-0'),
(8, 'user_8', '978-3-16-148417-0'),
(9, 'user_9', '978-3-16-148418-0'),
(10, 'user_10', '978-3-16-148419-0');

-- review_like 데이터
INSERT INTO review_like (review_like_id, user_id, review_id) VALUES
(1, 'user_1', 1),
(2, 'user_2', 2),
(3, 'user_3', 3),
(4, 'user_4', 4),
(5, 'user_5', 5),
(6, 'user_6', 6),
(7, 'user_7', 7),
(8, 'user_8', 8),
(9, 'user_9', 9),
(10, 'user_10', 10);

-- review_comments 데이터
INSERT INTO review_comments (comment_id, user_id, review_id, comment_content) VALUES
(1, 'user_1', 1, 'This is comment 1 on review 1.'),
(2, 'user_2', 2, 'This is comment 2 on review 2.'),
(3, 'user_3', 3, 'This is comment 3 on review 3.'),
(4, 'user_4', 4, 'This is comment 4 on review 4.'),
(5, 'user_5', 5, 'This is comment 5 on review 5.'),
(6, 'user_6', 6, 'This is comment 6 on review 6.'),
(7, 'user_7', 7, 'This is comment 7 on review 7.'),
(8, 'user_8', 8, 'This is comment 8 on review 8.'),
(9, 'user_9', 9, 'This is comment 9 on review 9.'),
(10, 'user_10', 10, 'This is comment 10 on review 10.');
