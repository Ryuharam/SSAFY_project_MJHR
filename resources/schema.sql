DROP DATABASE IF EXISTS mjhr_db;
CREATE DATABASE mjhr_db;
USE mjhr_db;

-- 사용자 테이블
CREATE TABLE users (
    user_id VARCHAR(50) PRIMARY KEY,
    user_pw VARCHAR(100) NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    user_email VARCHAR(100) UNIQUE NOT NULL,
    user_nic VARCHAR(50),
    user_img VARCHAR(255)
);

-- 책 테이블
CREATE TABLE books (
    isbn VARCHAR(20) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publisher VARCHAR(100),
    book_img VARCHAR(255),
    publication_date DATE
);

-- 독후감 테이블
CREATE TABLE reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    isbn VARCHAR(20),
    review_title VARCHAR(200) NOT NULL,
    review_content TEXT NOT NULL,  -- 길이에 대한 유연성 제공
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (isbn) REFERENCES books(isbn) ON DELETE CASCADE
);

-- 책 좋아요 테이블
CREATE TABLE book_like (
    book_like_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    isbn VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (isbn) REFERENCES books(isbn) ON DELETE CASCADE,
    UNIQUE KEY unique_book_like (user_id, isbn)
);

-- 독후감 좋아요 테이블
CREATE TABLE review_like (
    review_like_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    review_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (review_id) REFERENCES reviews(review_id) ON DELETE CASCADE,
    UNIQUE KEY unique_review_like (user_id, review_id)
);

-- 독후감 답글 테이블
CREATE TABLE review_comments (
    comment_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    review_id INT,
    comment_content TEXT NOT NULL,  -- 댓글 내용 추가
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (review_id) REFERENCES reviews(review_id) ON DELETE CASCADE
);


